package com.vincent.mvpcustomadvertisement.data.network;

import com.vincent.mvpcustomadvertisement.BuildConfig;

/**
 * Created by IDEA on 2019/3/17
 * User: Vincent
 * Time：16:45
 * Description: 配置获取资源的参数
 */
public final class ApiEndPoint {

    private ApiEndPoint() {
    }

    public static final String ENDPOINT_ADVERTISEMENT_URL = BuildConfig.BASE_URL + "ads/2100190001001/";
    public static final String ENDPOINT_ADVERTISEMENT_AD_JSON = BuildConfig.ADVERTISEMENT_JSON_FILE;


    ;
}
