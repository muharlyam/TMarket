package com.muharlyam.tmarket.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.muharlyam.domain.dto.RecommendationDto;
import com.muharlyam.data.repository.RecommendationRepositoryImpl;

public class RecommendationViewModel extends ViewModel {

    private final MutableLiveData<RecommendationDto> data;
    private final RecommendationRepositoryImpl recommendationRepositoryImpl;

    public RecommendationViewModel() {
        this.data = new MutableLiveData<>();
        this.recommendationRepositoryImpl = new RecommendationRepositoryImpl();
    }

    public void getRecommendation() {
        RecommendationDto recommendationDto = recommendationRepositoryImpl.getRecommendation();
        data.postValue(recommendationDto);
    }

    public MutableLiveData<RecommendationDto> getData() {
        return this.data;
    }
}
