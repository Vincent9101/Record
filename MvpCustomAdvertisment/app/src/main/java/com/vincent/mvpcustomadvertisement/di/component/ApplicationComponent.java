package com.vincent.mvpcustomadvertisement.di.component;

import android.app.Application;
import android.content.Context;
import com.danikula.videocache.HttpProxyCacheServer;
import com.vincent.mvpcustomadvertisement.AdvertisementApp;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.di.ApplicationContext;
import com.vincent.mvpcustomadvertisement.di.module.ApplicationModule;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:54
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(AdvertisementApp advertisementApp);


    /**
     * 以下三个函数的好处就是可以暴露该量给ActivityComponent域
     * 或者说是暴露给子域
     *
     * @return
     */
    @ApplicationContext
    Context getContext();

    Application getApplication();
    DataManager getDataManager();
    HttpProxyCacheServer getHttpProxyCacheServer();


}
