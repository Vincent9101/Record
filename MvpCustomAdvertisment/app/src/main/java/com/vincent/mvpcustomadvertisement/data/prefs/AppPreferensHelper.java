package com.vincent.mvpcustomadvertisement.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.vincent.mvpcustomadvertisement.di.ApplicationContext;
import com.vincent.mvpcustomadvertisement.di.PrefersInfo;
import com.vincent.mvpcustomadvertisement.util.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：17:52
 */
@Singleton
public class AppPreferensHelper implements PreferensHelper {
    private static final String PREF_KEY_BANNER_INTERVAL_TIME = " PREF_KEY_BANNER_INTERVAL_TIME";
    private static final String PREF_KEY_WAY_TO_PLAY = "PREF_KEY_WAY_TO_PLAY";
    private static final String PREF_KEY_IS_INITIALIZED = "PREF_KEY_IS_INITIALIZED";
    private final SharedPreferences sharedPreferences;

    @Inject
    public AppPreferensHelper(@ApplicationContext Context context, @PrefersInfo String prefFileName) {
        sharedPreferences = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public int getBannerIntervalTime() {
        return sharedPreferences.getInt(PREF_KEY_BANNER_INTERVAL_TIME, 30);

    }

    @Override
    public void setBannerIntervalTime(int bannerIntervalTime) {
        sharedPreferences.edit().putInt(PREF_KEY_BANNER_INTERVAL_TIME, bannerIntervalTime).apply();
    }

    @Override
    public AppConstants.WayToPlay getWayToPlay() {
        return AppConstants.WayToPlay.valueOf(sharedPreferences.getString(PREF_KEY_WAY_TO_PLAY, AppConstants.WayToPlay.FIRST_LANDSCAPE.toString()));
    }

    @Override
    public void setWayToPlay(AppConstants.WayToPlay wayToPlay) {


        sharedPreferences.edit().putString(PREF_KEY_WAY_TO_PLAY, wayToPlay.toString()).apply();

    }

    @Override
    public boolean getIsInitialized() {
        return sharedPreferences.getBoolean(PREF_KEY_IS_INITIALIZED, false);
    }

    @Override
    public void setIsInitialized(boolean isInitialized) {
        sharedPreferences.edit().putBoolean(PREF_KEY_IS_INITIALIZED, isInitialized).apply();

    }
}
