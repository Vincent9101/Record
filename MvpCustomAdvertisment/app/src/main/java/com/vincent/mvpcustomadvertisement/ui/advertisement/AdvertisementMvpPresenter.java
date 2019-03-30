package com.vincent.mvpcustomadvertisement.ui.advertisement;

import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.ui.base.MvpPresenter;

import java.util.Map;

/**
 * Created by IDEA on 2019/3/25
 * User: Vincent
 * Time：16:34
 */
public interface AdvertisementMvpPresenter<V extends AdvertisementMvpView> extends MvpPresenter<V> {
    void getAdvertisementResponse(AdvertisementRequest advertisementRequest);

    Map<String, Object> getSharedPreferensConfig();


}
