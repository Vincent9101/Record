package com.vincent.system.ui.user_management.add_user;

import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：15:16
 */
public interface AddUserMvpPresenter<V extends AddUserMvpView> extends MvpPresenter<V> {
    void doAddUser(String role, String account, String nickname);
}
