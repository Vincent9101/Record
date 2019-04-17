package com.vincent.system;

import android.app.Application;
import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.vincent.system.data.DataManager;
import com.vincent.system.di.component.ApplicationComponent;
import com.vincent.system.di.component.DaggerApplicationComponent;
import com.vincent.system.di.module.ApplicationModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/12
 * User: Vincent
 * Time：15:22
 */
public class EvaluatingSystemApp extends Application {
    @Inject
    DataManager mDataManager;
    @Inject
    CalligraphyConfig mCalligraphyConfig;


    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);



        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
