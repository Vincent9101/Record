package com.vincent.mvpcustomadvertisement.ui.advertisement;

import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import com.vincent.mvpcustomadvertisement.ui.base.MvpView;

/**
 * Created by IDEA on 2019/3/25
 * User: Vincent
 * Time：16:29
 */
public interface AdvertisementMvpView extends MvpView {
    void playAdvertisement(AdvertisementResponse advertisementResponse, Long timeNumber);
}
