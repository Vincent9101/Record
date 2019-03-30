package com.vincent.mvpcustomadvertisement.util;

import android.webkit.WebChromeClient;
import com.vincent.mvpcustomadvertisement.di.PrefersInfo;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：18:02
 */
public final class AppConstants {

    public static final String PREFERS_NAME = "ADVERTISEMENT_PREFERS_FILE";
    public static final String DATA_KEY_WAY_TO_PLAY = "DATA_KEY_WAY_TO_PLAY";
    public static final String DATA_KEY_INTERVAL_TIME = "DATA_KEY_INTERVAL_TIME";

    public static enum WayToPlay {
        FIRST_LANDSCAPE, SECOND_PORTRAIT;

    }
}
