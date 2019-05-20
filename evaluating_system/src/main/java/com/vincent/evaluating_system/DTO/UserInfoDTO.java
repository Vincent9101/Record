package com.vincent.evaluating_system.DTO;

import lombok.Data;

/**
 * Created by IDEA on 2019/4/7
 * User: Vincent
 * Time：16:57
 */
@Data
public class UserInfoDTO {
    private String roleValue;
    private String account;
    private String nickname;

    public UserInfoDTO() {
    }

    public UserInfoDTO(String roleValue, String account, String nickname) {
        this.roleValue = roleValue;
        this.account = account;
        this.nickname = nickname;
    }
}
