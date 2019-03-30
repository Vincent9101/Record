package com.vincent.mvpcustomadvertisement.data.prefs;

import com.vincent.mvpcustomadvertisement.util.AppConstants;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：17:51
 */
public interface PreferensHelper {

    int getBannerIntervalTime();

    void setBannerIntervalTime(int bannerIntervalTime);

    AppConstants.WayToPlay getWayToPlay();

    void setWayToPlay(AppConstants.WayToPlay way);

    boolean getIsInitialized();

    void setIsInitialized(boolean isInitialized);

}
