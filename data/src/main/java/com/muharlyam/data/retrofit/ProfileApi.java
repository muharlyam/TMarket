package com.muharlyam.data.retrofit;

import com.muharlyam.domain.dto.profile.ProfileDto;
import com.muharlyam.domain.dto.profile.TokenDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ProfileApi {

    @POST("/api/v1/profile/signup")
    Call<ProfileDto> createProfile(@Body TokenDto tokenDto);
}
