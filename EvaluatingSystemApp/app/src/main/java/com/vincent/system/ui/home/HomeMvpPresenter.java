package com.vincent.system.ui.home;

import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：13:03
 */
@PerActivity
public interface HomeMvpPresenter<V extends HomeMvpView> extends MvpPresenter<V> {
    void setUserInfoFromData();

    void logOffUser();
}
