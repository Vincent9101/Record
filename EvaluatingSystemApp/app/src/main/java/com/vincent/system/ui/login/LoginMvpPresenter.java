package com.vincent.system.ui.login;


import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.base.MvpPresenter;


@PerActivity
public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void onServerLoginClick(String account, String password);


}
