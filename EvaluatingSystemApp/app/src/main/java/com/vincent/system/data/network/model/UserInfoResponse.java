package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:35
 */
public class UserInfoResponse {

    @Expose
    @SerializedName("code")
    private int statusCode;
    @Expose
    @SerializedName("code_desc")
    private String statusCodeDesc;
    @Expose
    @SerializedName("msg")
    private String message;
    @Expose
    @SerializedName("super_users")
    private List<UserInfo> superUserInfoList;
    @Expose
    @SerializedName("normal_users")
    private List<UserInfo> normalUserInfoList;

    public static class UserInfo  {

        @Expose
        @SerializedName("roleValue")
        private String roleValue;

        @Expose
        @SerializedName("account")
        private String account;

        @Expose
        @SerializedName("nickname")
        private String nickname;


        @Override
        public String toString() {
            return "UserInfo{" +
                    "roleValue='" + roleValue + '\'' +
                    ", account='" + account + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            UserInfo userInfo = (UserInfo) o;

            if (roleValue != null ? !roleValue.equals(userInfo.roleValue) : userInfo.roleValue != null) return false;
            if (account != null ? !account.equals(userInfo.account) : userInfo.account != null) return false;
            return nickname != null ? nickname.equals(userInfo.nickname) : userInfo.nickname == null;
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

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCodeDesc() {
        return statusCodeDesc;
    }

    public void setStatusCodeDesc(String statusCodeDesc) {
        this.statusCodeDesc = statusCodeDesc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UserInfoResponse{" +
                "statusCode='" + statusCode + '\'' +
                ", statusCodeDesc='" + statusCodeDesc + '\'' +
                ", message='" + message + '\'' +
                ", superUserInfoList=" + superUserInfoList +
                ", normalUserInfoList=" + normalUserInfoList +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoResponse that = (UserInfoResponse) o;

        if (statusCode != that.statusCode) return false;
        if (statusCodeDesc != null ? !statusCodeDesc.equals(that.statusCodeDesc) : that.statusCodeDesc != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (superUserInfoList != null ? !superUserInfoList.equals(that.superUserInfoList) : that.superUserInfoList != null)
            return false;
        return normalUserInfoList != null ? normalUserInfoList.equals(that.normalUserInfoList) : that.normalUserInfoList == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode;
        result = 31 * result + (statusCodeDesc != null ? statusCodeDesc.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (superUserInfoList != null ? superUserInfoList.hashCode() : 0);
        result = 31 * result + (normalUserInfoList != null ? normalUserInfoList.hashCode() : 0);
        return result;
    }

    public List<UserInfo> getSuperUserInfoList() {
        return superUserInfoList;
    }

    public void setSuperUserInfoList(List<UserInfo> superUserInfoList) {
        this.superUserInfoList = superUserInfoList;
    }

    public List<UserInfo> getNormalUserInfoList() {
        return normalUserInfoList;
    }

    public void setNormalUserInfoList(List<UserInfo> normalUserInfoList) {
        this.normalUserInfoList = normalUserInfoList;
    }
}
