package com.vincent.system.ui.user_management.user_info;

import com.vincent.system.data.network.model.UserInfoResponse;
import com.vincent.system.ui.base.MvpView;

import java.util.List;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:21
 */
public interface UserMvpView extends MvpView {
    void updateUserInfos(List<UserInfoResponse.UserInfo> userInfoList);
}
