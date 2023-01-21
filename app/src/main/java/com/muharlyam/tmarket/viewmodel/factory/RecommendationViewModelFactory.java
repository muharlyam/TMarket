package com.muharlyam.tmarket.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.muharlyam.tmarket.viewmodel.RecommendationViewModel;

public class RecommendationViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RecommendationViewModel();
    }
}
