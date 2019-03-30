package com.vincent.mvpcustomadvertisement.data.network;

import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import io.reactivex.Single;

/**
 * Created by IDEA on 2019/3/17
 * User: Vincent
 * Time：11:23
 */
public interface ApiHelper {
    ApiHeader getApiHeader();
    Single<AdvertisementResponse> getAdvertisement(AdvertisementRequest advertisementRequest);
}
