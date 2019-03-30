package com.vincent.mvpcustomadvertisement.ui.advertisement;

import android.util.Log;
import com.danikula.videocache.HttpProxyCacheServer;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import com.vincent.mvpcustomadvertisement.ui.base.BasePresenter;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import com.vincent.mvpcustomadvertisement.util.rx.RxTimer;
import com.vincent.mvpcustomadvertisement.util.rx.SchedulerProvider;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by IDEA on 2019/3/25
 * User: Vincent
 * Time：16:35
 */
public class AdvertisementPresenter<V extends AdvertisementMvpView> extends BasePresenter<V> implements AdvertisementMvpPresenter<V> {

    private final String TAG = "AdvertisementPresenter";
    private HttpProxyCacheServer httpProxyCacheServer;

    @Inject
    public AdvertisementPresenter(HttpProxyCacheServer httpProxyCacheServer, DataManager mDataManger, SchedulerProvider schedulerProvider, CompositeDisposable disposable) {
        super(mDataManger, schedulerProvider, disposable);
        this.httpProxyCacheServer = httpProxyCacheServer;
    }

    public HttpProxyCacheServer getHttpProxyCacheServer() {
        return httpProxyCacheServer;
    }

    @Override
    public void getAdvertisementResponse(final AdvertisementRequest advertisementRequest) {

        RxTimer.Action action = new RxTimer.Action() {
            @Override
            public void action(final Long timeNumber) {
                Log.d(TAG, " Action Begins");
                final Single<AdvertisementResponse> observable = getDataManger().getAdvertisement(advertisementRequest);
                Disposable disposable = observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<AdvertisementResponse>() {
                            @Override
                            public void accept(AdvertisementResponse advertisementResponse) throws Exception {

                                Log.d(TAG, "Return Response");
                                getMvpView().playAdvertisement(advertisementResponse, timeNumber);
                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                Log.e(TAG, "getting  response  failed");
                            }
                        });
                getDisposable().add(disposable);
            }
        };
        RxTimer.interval(60L, TimeUnit.MINUTES, TAG, action, getDisposable());
    }

    @Override
    public Map<String, Object> getSharedPreferensConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put(AppConstants.DATA_KEY_WAY_TO_PLAY, getDataManger().getWayToPlay());
        map.put(AppConstants.DATA_KEY_INTERVAL_TIME, getDataManger().getBannerIntervalTime());
        return map;
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}
