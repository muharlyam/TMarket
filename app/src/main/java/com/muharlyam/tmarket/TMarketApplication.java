package com.muharlyam.tmarket;

import android.app.Application;

import com.muharlyam.data.entity.DaoMaster;
import com.muharlyam.data.entity.DaoSession;
import com.muharlyam.tmarket.dagger.component.DaggerProfileComponent;
import com.muharlyam.tmarket.dagger.component.DaggerRecommendationComponent;
import com.muharlyam.tmarket.dagger.component.ProfileComponent;
import com.muharlyam.tmarket.dagger.component.RecommendationComponent;
import com.muharlyam.tmarket.dagger.module.ProfileModule;

import org.greenrobot.greendao.database.Database;

public class TMarketApplication extends Application {
    ProfileComponent profileComponent;
    RecommendationComponent recommendationComponent;
    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        profileComponent = DaggerProfileComponent.builder().profileModule(new ProfileModule()).build();
        recommendationComponent = DaggerRecommendationComponent.create();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "notes-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
}