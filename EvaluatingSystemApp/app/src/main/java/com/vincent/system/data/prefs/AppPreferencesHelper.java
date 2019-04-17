package com.vincent.system.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.vincent.system.data.DataManager;
import com.vincent.system.di.ApplicationContext;
import com.vincent.system.di.PreferenceInfo;
import com.vincent.system.util.AppConstants;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_USER_LOGGED_IN_MODE = "PREF_KEY_USER_LOGGED_IN_MODE";
    private static final String PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME";
    private static final String PREF_KEY_CURRENT_USER_ACCOUNT = "PREF_KEY_CURRENT_USER_ACCOUNT";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";
    private static final String PREF_KEY_ROLE_VALUE = "PREF_KEY_ROLE_VALUE";

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context,
                                @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }

    @Override
    public String getCurrentUserName() {

        return mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null);
    }

    @Override
    public void setCurrentUserName(String userName) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply();
    }

    @Override
    public String getCurrentUserAccount() {
        return mPrefs.getString(PREF_KEY_CURRENT_USER_ACCOUNT, null);
    }

    @Override
    public void setCurrentUserAccount(String account) {
        mPrefs.edit().putString(PREF_KEY_CURRENT_USER_ACCOUNT, account).apply();

    }


    @Override
    public String getRoleValue() {

        return mPrefs.getString(PREF_KEY_ROLE_VALUE, null);
    }

    @Override
    public void setRoleValue(String roleValue) {
        mPrefs.edit().putString(PREF_KEY_ROLE_VALUE, roleValue).apply();

    }

    @Override
    public int getCurrentUserLoggedInMode() {
        return mPrefs.getInt(PREF_KEY_USER_LOGGED_IN_MODE,
                DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType());
    }


    @Override
    public void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode) {
        mPrefs.edit().putInt(PREF_KEY_USER_LOGGED_IN_MODE, mode.getType()).apply();
    }

    @Override
    public String getAccessToken() {
        return mPrefs.getString(PREF_KEY_ACCESS_TOKEN, null);
    }

    @Override
    public void setAccessToken(String accessToken) {
        mPrefs.edit().putString(PREF_KEY_ACCESS_TOKEN, accessToken).apply();
    }
}
