package com.muharlyam.data.repository;

import com.muharlyam.data.retrofit.ProfileApi;
import com.muharlyam.data.retrofit.RetrofitFactory;
import com.muharlyam.domain.dto.profile.ProfileDto;
import com.muharlyam.domain.dto.profile.TokenDto;
import com.muharlyam.domain.repository.ProfileRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class ProfileRepositoryImpl implements ProfileRepository {

    private final ProfileApi profileApi;


    public ProfileRepositoryImpl() {
        profileApi = RetrofitFactory.getInstance().create(ProfileApi.class);
    }

    @Override
    public ProfileDto createUser(TokenDto tokenDto) {
        ProfileDto profileDto = new ProfileDto();
        Call<ProfileDto> call = profileApi.createProfile(tokenDto);
        try {
            Response<ProfileDto> result = call.execute();
            if(result.isSuccessful()) {
                profileDto = result.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileDto;
    }
}
