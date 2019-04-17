package com.vincent.system.ui.personal_info;

import com.vincent.system.ui.base.MvpView;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：15:58
 */
public interface PersonalInfoMvpView extends MvpView {
    void showInfo(String roleValue, String account, String nickname);
}
