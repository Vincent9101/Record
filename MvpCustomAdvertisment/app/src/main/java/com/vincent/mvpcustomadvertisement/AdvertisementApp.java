package com.vincent.mvpcustomadvertisement;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.danikula.videocache.HttpProxyCacheServer;
import com.squareup.leakcanary.LeakCanary;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.di.component.ApplicationComponent;
import com.vincent.mvpcustomadvertisement.di.component.DaggerApplicationComponent;
import com.vincent.mvpcustomadvertisement.di.module.ApplicationModule;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementActivity;
import com.vincent.mvpcustomadvertisement.ui.init.InitActivity;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:57
 */

public class AdvertisementApp extends Application {
    @Inject
    DataManager mDataManager;
    private ApplicationComponent applicationComponent;

    @Inject
    HttpProxyCacheServer httpProxyCacheServer;

    @Override
    public void onCreate() {
        super.onCreate();
        //检测内存泄露
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

        applicationComponent = DaggerApplicationComponent.builder().
                applicationModule(new ApplicationModule(this)).
                build();

        applicationComponent.inject(this);

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
        if (getApplicationComponent().getDataManager().getIsInitialized()) {
            Intent intent=AdvertisementActivity.getStartIntent(getApplicationContext());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }else
        {
            Intent intent=InitActivity.getStartIntent(getApplicationContext());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
