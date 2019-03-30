package com.vincent.mvpcustomadvertisement.ui.base;

/**
 * Created by IDEA on 2019/3/22
 * User: Vincent
 * Time：14:10
 */
public interface SubMvpView extends MvpView {
    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

    void attachParentMvpView(MvpView mvpView);
}
