package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：15:28
 */
public class AddUserRequest {
    @Expose
    @SerializedName("roleValue")
    private String roleValue;

    @Expose
    @SerializedName("account")
    private String account;

    @Expose
    @SerializedName("nickname")
    private String nickname;

    public AddUserRequest(String roleValue, String account, String nickname) {
        this.roleValue = roleValue;
        this.account = account;
        this.nickname = nickname;
    }

    public AddUserRequest() {
    }

    @Override
    public String toString() {
        return "AddUserRequest{" +
                "roleValue='" + roleValue + '\'' +
                ", account='" + account + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddUserRequest that = (AddUserRequest) o;

        if (roleValue != null ? !roleValue.equals(that.roleValue) : that.roleValue != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        return nickname != null ? nickname.equals(that.nickname) : that.nickname == null;
    }

    @Override
    public int hashCode() {
        int result = roleValue != null ? roleValue.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
