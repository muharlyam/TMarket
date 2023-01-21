package com.muharlyam.tmarket.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.muharlyam.tmarket.dto.RecommendationDto;
import com.muharlyam.tmarket.retrofit.RecommendationApi;
import com.muharlyam.tmarket.retrofit.RetrofitFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepository {

    private static RecommendationApi recommendationApi;
    private static NetworkRepository networkRepository;
    private final MutableLiveData<RecommendationDto> recommendation = new MutableLiveData<>();

    public static NetworkRepository getInstance() {
        if (networkRepository == null) {
            networkRepository = new NetworkRepository();
        }
        return networkRepository;
    }

    public NetworkRepository() {
        recommendationApi = RetrofitFactory.getInterface();
    }

    public MutableLiveData<RecommendationDto> getRecommendation() {
        Call<RecommendationDto> call = recommendationApi.getRecommendation();
        call.enqueue(new Callback<RecommendationDto>() {
            @Override
            public void onResponse(@NonNull Call<RecommendationDto> call, @NonNull Response<RecommendationDto> response) {
                recommendation.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<RecommendationDto> call, @NonNull Throwable t) {
                recommendation.postValue(null);
            }
        });
        return recommendation;
    }
}
