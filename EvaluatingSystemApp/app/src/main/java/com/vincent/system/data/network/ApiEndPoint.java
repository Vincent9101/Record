package com.vincent.system.data.network;

import com.vincent.system.BuildConfig;


public final class ApiEndPoint {


    public static final String ENDPOINT_SERVER_LOGIN = BuildConfig.BASE_URL
            + "/login";

    public static final String ENDPOINT_LOGOUT = BuildConfig.BASE_URL
            + "/logout";

    public static final String ENDPOINT_INFO = BuildConfig.BASE_URL
            + "/api/info";

    public static final String ENDPOINT_USER_MANAGEMENT = BuildConfig.BASE_URL
            + "/api/user_management/user";

    public static final String ENDPOINT_LOGOFF = BuildConfig.BASE_URL
            + "/api/logoff";

    public static final String ENDPOINT_PATIENT_RECORD = BuildConfig.BASE_URL +
            "/api/patient_record";

    public static final String ENDPOINT_OPEN_SOURCE = BuildConfig.BASE_URL
            + "/5926c34212000035026871cd";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
