package com.vincent.system.data.prefs;

import com.vincent.system.data.DataManager;

public interface PreferencesHelper {

    String getRoleValue();

    void setRoleValue(String roleValue);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserAccount();

    void setCurrentUserAccount(String account);

    String getAccessToken();

    void setAccessToken(String accessToken);

}
