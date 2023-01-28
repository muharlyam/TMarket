package com.muharlyam.data.repository;

import static com.muharlyam.domain.utils.Constants.FAILURE_PROFILE;

import com.muharlyam.data.retrofit.RecommendationApi;
import com.muharlyam.data.retrofit.RetrofitFactory;
import com.muharlyam.domain.dto.RecommendationDto;
import com.muharlyam.domain.repository.RecommendationRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class RecommendationRepositoryImpl implements RecommendationRepository {

    private static RecommendationApi recommendationApi;


    public RecommendationRepositoryImpl() {
        recommendationApi = RetrofitFactory.getInterface();
    }

    public RecommendationDto getRecommendation() {
        RecommendationDto recommendation = new RecommendationDto();
        Call<RecommendationDto> call = recommendationApi.getRecommendation();
        try {
            Response<RecommendationDto> result = call.execute();
            if(result.isSuccessful()) {
                recommendation = result.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
            recommendation.setProfileId(FAILURE_PROFILE);
        }
        return recommendation;
    }
}
