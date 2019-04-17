package com.vincent.system.data;

import com.vincent.system.data.network.ApiHelper;
import com.vincent.system.data.prefs.PreferencesHelper;


public interface DataManager extends PreferencesHelper, ApiHelper {

    void updateApiHeader(String accessToken);

    void setUserAsLoggedOut();

    void updateUserInfo(
            String accessToken,
            LoggedInMode loggedInMode,
            String userName,
            String account,
            String roleValue);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }
}
