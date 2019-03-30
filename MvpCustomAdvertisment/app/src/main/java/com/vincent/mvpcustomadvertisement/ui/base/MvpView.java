package com.vincent.mvpcustomadvertisement.ui.base;

import android.support.annotation.StringRes;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:44
 */
public interface MvpView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();
}
