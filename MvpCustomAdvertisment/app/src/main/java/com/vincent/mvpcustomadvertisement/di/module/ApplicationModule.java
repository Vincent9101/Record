package com.vincent.mvpcustomadvertisement.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.danikula.videocache.HttpProxyCacheServer;
import com.vincent.mvpcustomadvertisement.data.AppDataManager;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.data.network.ApiHelper;
import com.vincent.mvpcustomadvertisement.data.network.AppApiHelper;
import com.vincent.mvpcustomadvertisement.data.prefs.AppPreferensHelper;
import com.vincent.mvpcustomadvertisement.data.prefs.PreferensHelper;
import com.vincent.mvpcustomadvertisement.di.ApplicationContext;
import com.vincent.mvpcustomadvertisement.di.PrefersInfo;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:55
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    public Context providedContext() {
        return mApplication;
    }

    @Provides
    public Application providedApplication() {
        return mApplication;
    }

    //

    @Provides
    @Singleton
    public DataManager providedDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }


    @Provides
    @Singleton
    public ApiHelper providedApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Singleton
    @Provides
    public PreferensHelper providedPreferensHelper(AppPreferensHelper appPreferensHelper) {
        return appPreferensHelper;
    }


    @Provides
    @Singleton
    public HttpProxyCacheServer providedProxyCacheServer(@ApplicationContext Context context) {
        return new HttpProxyCacheServer.Builder(context)
                .maxCacheSize(1024 * 1024 * 1024) //1Gb 缓存
                .maxCacheFilesCount(10)
                .build();
    }

    @Provides
    @PrefersInfo
    public String providedPrefersFileName() {
        return AppConstants.PREFERS_NAME;
    }

}
