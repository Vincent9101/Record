package com.vincent.mvpcustomadvertisement.ui.init;

import com.vincent.mvpcustomadvertisement.ui.base.MvpPresenter;

import java.util.Map;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：18:43
 */
public interface InitMvpPresenter<V extends InitMvpView> extends MvpPresenter<V> {
    void setUpInit(Map<String, Object> dataMap);

    boolean isInitialized();
}
