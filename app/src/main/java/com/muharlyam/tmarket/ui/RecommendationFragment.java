package com.muharlyam.tmarket.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.muharlyam.tmarket.R;
import com.muharlyam.tmarket.adapter.ProductAdapter;
import com.muharlyam.tmarket.adapter.StoreAdapter;
import com.muharlyam.domain.dto.RecommendationDto;
import com.muharlyam.tmarket.viewmodel.RecommendationViewModel;

import java.util.concurrent.Executors;

public class RecommendationFragment extends Fragment {

    RecommendationViewModel recommendationViewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recommendation, container, false);
        auth(view);
        init(view);
        getDataFromApi();
        return view;

    }

    private void init(View view) {
        recommendationViewModel = new ViewModelProvider(this)
                .get(RecommendationViewModel.class);
        recommendationViewModel.getData()
                .observe(getViewLifecycleOwner(), recommendationDto -> {
                    setProductAdapter(view, recommendationDto);
                    setStoreAdapter(view, recommendationDto);
                });
    }

    private void auth(View view) {
        Button authButton = view.findViewById(R.id.auth_bt);
        authButton.setOnClickListener(v -> Navigation
                .findNavController(requireActivity(), R.id.nav_host_fragment)
                .navigate(R.id.action_splashFragment_to_signUpFragment));
    }

    private void getDataFromApi() {
        Executors.newCachedThreadPool().execute(() -> {
            recommendationViewModel.getRecommendation();
        });

    }

    private void setProductAdapter(View view, RecommendationDto recommendationDto) {
        RecyclerView recyclerView = view.findViewById(R.id.rec_like_prod_list);
        ProductAdapter productAdapter =
                new ProductAdapter(recommendationDto.getLikeProducts());
        recyclerView.setAdapter(productAdapter);

        recyclerView = view.findViewById(R.id.rec_top_prod_txt_list);
        productAdapter =
                new ProductAdapter(recommendationDto.getTopProducts());
        recyclerView.setAdapter(productAdapter);
    }

    private void setStoreAdapter(View view, RecommendationDto recommendationDto) {
        RecyclerView recyclerView = view.findViewById(R.id.rec_like_store_list);
        StoreAdapter storeAdapter =
                new StoreAdapter(recommendationDto.getLikeStores());
        recyclerView.setAdapter(storeAdapter);

        recyclerView = view.findViewById(R.id.rec_top_store_txt_list);
        storeAdapter =
                new StoreAdapter(recommendationDto.getTopStores());
        recyclerView.setAdapter(storeAdapter);
    }
}
