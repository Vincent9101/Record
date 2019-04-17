package com.vincent.system.ui.user_management;

import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：18:50
 */
@PerActivity
public interface ManagementMvpPresenter<V extends ManagementMvpView> extends MvpPresenter<V> {
}
