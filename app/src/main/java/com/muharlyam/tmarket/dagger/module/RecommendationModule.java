package com.muharlyam.tmarket.dagger.module;

import com.muharlyam.data.repository.RecommendationRepositoryImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class RecommendationModule {
    @Provides
    RecommendationRepositoryImpl provideRecommendationRepository() {
        return new RecommendationRepositoryImpl();
    }
}
