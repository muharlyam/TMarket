package com.muharlyam.tmarket.retrofit;

import com.muharlyam.tmarket.dto.RecommendationDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecommendationApi {

    @GET("/api/v1/recommendation")
    Call<RecommendationDto> getRecommendation();
}
