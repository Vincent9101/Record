package com.vincent.mvpcustomadvertisement.data.network;

import com.rx2androidnetworking.Rx2AndroidNetworking;
;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by IDEA on 2019/3/17
 * User: Vincent
 * Time：11:22
 */
@Singleton
public class AppApiHelper implements ApiHelper {

    //TODO: 后续看是否需要请求头
    private ApiHeader apiHeader;

    @Inject
    public AppApiHelper() {
    }

    @Override
    public ApiHeader getApiHeader() {
        return apiHeader;
    }

    @Override
    public Single<AdvertisementResponse> getAdvertisement(AdvertisementRequest advertisementRequest) {
        return Rx2AndroidNetworking.get(advertisementRequest.getUrl())
                .build()
                .getObjectSingle(AdvertisementResponse.class);
    }
}
