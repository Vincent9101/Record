package com.vincent.system.ui.home;

import android.view.Gravity;
import com.vincent.system.ui.base.MvpView;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：13:03
 */
public interface HomeMvpView extends MvpView {
    void setUserInfo(String nickname, String account, boolean isSuper);

    void onClickLogout();

    void closeNavigationDrawer();

    void onLogOffUser();

}
