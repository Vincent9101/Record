package com.vincent.mvpcustomadvertisement.data;

import android.content.Context;
import com.vincent.mvpcustomadvertisement.data.network.ApiHeader;
import com.vincent.mvpcustomadvertisement.data.network.ApiHelper;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import com.vincent.mvpcustomadvertisement.data.prefs.PreferensHelper;
import com.vincent.mvpcustomadvertisement.di.ApplicationContext;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import io.reactivex.Single;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：20:33
 */
@Singleton
public class AppDataManager implements DataManager {
    private String TAG = "AppDataManager";
    private final Context mContext;
    private final ApiHelper mApiHelper;
    private final PreferensHelper preferensHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context mContext, ApiHelper mApiHelper, PreferensHelper preferensHelper) {
        this.mContext = mContext;
        this.mApiHelper = mApiHelper;
        this.preferensHelper = preferensHelper;
    }


    @Override
    public ApiHeader getApiHeader() {
        return null;
    }

    @Override
    public Single<AdvertisementResponse> getAdvertisement(AdvertisementRequest advertisementRequest) {

        return mApiHelper.getAdvertisement(advertisementRequest);
    }

    @Override
    public int getBannerIntervalTime() {
        return preferensHelper.getBannerIntervalTime();
    }

    @Override
    public void setBannerIntervalTime(int bannerIntervalTime) {
        preferensHelper.setBannerIntervalTime(bannerIntervalTime);
    }

    @Override
    public AppConstants.WayToPlay getWayToPlay() {
        return preferensHelper.getWayToPlay();
    }

    @Override
    public void setWayToPlay(AppConstants.WayToPlay way) {
        preferensHelper.setWayToPlay(way);
    }

    @Override
    public boolean getIsInitialized() {
        return preferensHelper.getIsInitialized();
    }

    @Override
    public void setIsInitialized(boolean isInitialized) {
        preferensHelper.setIsInitialized(isInitialized);

    }
}
