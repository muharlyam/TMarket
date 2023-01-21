package com.muharlyam.tmarket.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.muharlyam.tmarket.dto.RecommendationDto;
import com.muharlyam.tmarket.repository.NetworkRepository;

public class RecommendationViewModel extends ViewModel {
    private final NetworkRepository networkRepository;

    public RecommendationViewModel() {
        networkRepository = new NetworkRepository();
    }

    public MutableLiveData<RecommendationDto> getRecommendation() {
        return networkRepository.getRecommendation();
    }
}
