package com.vincent.mvpcustomadvertisement.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.vincent.mvpcustomadvertisement.di.ActivityContext;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementMvpPresenter;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementMvpView;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementPresenter;
import com.vincent.mvpcustomadvertisement.ui.init.InitActivity;
import com.vincent.mvpcustomadvertisement.ui.init.InitMvpPresenter;
import com.vincent.mvpcustomadvertisement.ui.init.InitMvpView;
import com.vincent.mvpcustomadvertisement.ui.init.InitPresenter;
import com.vincent.mvpcustomadvertisement.util.rx.AppScheduleProvider;
import com.vincent.mvpcustomadvertisement.util.rx.SchedulerProvider;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:13
 */
@Module
public class ActivityModule {
    private AppCompatActivity appCompatActivity;

    public ActivityModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    /**
     * 以下用以提供构造参数
     */
    @Provides
    public AppCompatActivity provideActivity() {
        return appCompatActivity;
    }

    @Provides
    public CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @ActivityContext

    public Context provideContext() {
        return appCompatActivity;
    }


    @Provides
    public AdvertisementMvpPresenter<AdvertisementMvpView> provideAdvertisementMvpPresenter
            (AdvertisementPresenter<AdvertisementMvpView> advertisementPresenter) {

        return advertisementPresenter;
    }

    @Provides
    public InitMvpPresenter<InitMvpView> provideInitMvpPresenter(InitPresenter<InitMvpView> initMvpViewInitPresenter) {
        return initMvpViewInitPresenter;
    }

    @Provides
    public LinearLayoutManager provideLinearLayoutManager(AppCompatActivity appCompatActivity) {
        return new LinearLayoutManager(appCompatActivity);
    }


    @Provides
    public SchedulerProvider provideSchedulerProvider() {
        return new AppScheduleProvider();
    }
}
