package com.muharlyam.data.retrofit;

import com.muharlyam.domain.dto.RecommendationDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecommendationApi {

    @GET("/api/v1/recommendation")
    Call<RecommendationDto> getRecommendation();
}
