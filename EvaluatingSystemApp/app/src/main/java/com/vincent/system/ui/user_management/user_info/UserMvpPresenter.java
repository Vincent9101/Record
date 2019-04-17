package com.vincent.system.ui.user_management.user_info;

import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:22
 */
public interface UserMvpPresenter<V extends UserMvpView> extends MvpPresenter<V> {
    void doGetUserInfo(int userType);
}
