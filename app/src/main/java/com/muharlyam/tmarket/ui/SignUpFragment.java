package com.muharlyam.tmarket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GoogleAuthProvider;
import com.muharlyam.data.repository.ProfileRepositoryImpl;
import com.muharlyam.domain.dto.profile.TokenDto;
import com.muharlyam.domain.repository.ProfileRepository;
import com.muharlyam.data.service.ProfileService;
import com.muharlyam.tmarket.R;

import java.util.concurrent.Executors;

import javax.inject.Inject;


public class SignUpFragment extends Fragment implements View.OnClickListener {

    private SignInButton googleSignInButton;
    private NavController navController;
    private GoogleSignInClient googleSignInClient;
    private FirebaseAuth firebaseAuth;
    private final static int GOOGLE_SIGN_IN_REQUEST_CODE = 1;

    @Inject
    public ProfileRepository profileRepository;
    ProfileService profileService;

    private void init() {
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("128154773507-du2lm8cpse7fabmjo16hv3ffnsv5ujhj.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), options);
        firebaseAuth = FirebaseAuth.getInstance();
        profileService = new ProfileService(profileRepository);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);
        googleSignInButton = rootView.findViewById(R.id.googleSignInButton);
        googleSignInButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        init();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.googleSignInButton) {
            googleSignUp();
        }
    }

    private void googleSignUp() {
        Intent signInIntent = googleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GOOGLE_SIGN_IN_REQUEST_CODE) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleGoogleSignInResult(task);
        }
    }

    private void handleGoogleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            String idToken = account.getIdToken();
            handlerAuthCredentials(GoogleAuthProvider.getCredential(idToken, null));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handlerAuthCredentials(AuthCredential credential) {

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity(), getAuthResult());
    }

    private OnCompleteListener<AuthResult> getAuthResult() {
        return task -> {
            if (task.isSuccessful()) {
                FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                if (currentUser != null) {
                    currentUser.getIdToken(true)
                            .addOnSuccessListener(createUser());
                }
            }
        };
    }

    private OnSuccessListener<GetTokenResult> createUser() {
        return tokenResult -> {
            TokenDto tokenDto = new TokenDto(tokenResult.getToken());
            Executors.newCachedThreadPool().execute(
                    () -> {
                        profileService.createUser(tokenDto);
                    });
        };
    }

}