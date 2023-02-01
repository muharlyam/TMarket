package com.muharlyam.tmarket;

import android.app.Application;

import com.muharlyam.tmarket.dagger.component.DaggerProfileComponent;
import com.muharlyam.tmarket.dagger.component.DaggerRecommendationComponent;
import com.muharlyam.tmarket.dagger.component.ProfileComponent;
import com.muharlyam.tmarket.dagger.component.RecommendationComponent;
import com.muharlyam.tmarket.dagger.module.ProfileModule;

public class TMarketApplication extends Application {
    ProfileComponent profileComponent;
    RecommendationComponent recommendationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        profileComponent = DaggerProfileComponent.builder().profileModule(new ProfileModule()).build();
        recommendationComponent = DaggerRecommendationComponent.create();
    }
}