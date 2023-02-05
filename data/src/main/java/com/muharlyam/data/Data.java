package com.muharlyam.data;

import android.app.Application;

import com.muharlyam.data.entity.DaoMaster;
import com.muharlyam.data.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

public class Data extends Application {

    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}