package com.vincent.mvpcustomadvertisement.ui.init;

import com.androidnetworking.error.ANError;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.ui.base.BasePresenter;
import com.vincent.mvpcustomadvertisement.ui.base.MvpView;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import com.vincent.mvpcustomadvertisement.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：18:46
 */
public class InitPresenter<V extends InitMvpView> extends BasePresenter<V> implements InitMvpPresenter<V> {

    @Inject
    public InitPresenter(DataManager mDataManger, SchedulerProvider schedulerProvider, CompositeDisposable disposable) {
        super(mDataManger, schedulerProvider, disposable);
    }

    @Override
    public void setUpInit(Map dataMap) {
        getDataManger().setBannerIntervalTime((Integer) dataMap.get(AppConstants.DATA_KEY_INTERVAL_TIME));
        getDataManger().setWayToPlay((AppConstants.WayToPlay) dataMap.get(AppConstants.DATA_KEY_WAY_TO_PLAY));
        getDataManger().setIsInitialized(true);
    }

    @Override
    public boolean isInitialized() {
        return getDataManger().getIsInitialized();
    }
}
