package com.muharlyam.tmarket.dagger.component;

import com.muharlyam.tmarket.dagger.module.RecommendationModule;
import com.muharlyam.tmarket.viewmodel.RecommendationViewModel;

import dagger.Component;

@Component(modules = RecommendationModule.class)
public interface RecommendationComponent {
    void inject(RecommendationViewModel obj);
}
