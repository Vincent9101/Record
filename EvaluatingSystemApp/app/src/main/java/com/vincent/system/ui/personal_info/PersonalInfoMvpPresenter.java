package com.vincent.system.ui.personal_info;

import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.ui.base.MvpPresenter;
import com.vincent.system.ui.base.MvpView;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：15:58
 */
@PerActivity
public interface PersonalInfoMvpPresenter<V extends PersonalInfoMvpView>
        extends MvpPresenter<V> {
    void showInfo();

    void changeInfo(String nickname, String password);
}
