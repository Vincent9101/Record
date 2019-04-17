package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @Expose
    @SerializedName("code")
    private int statusCode;

    @Expose
    @SerializedName("nickname")
    private String nickname;
    @Expose
    @SerializedName("account")
    private String account;

    @Expose
    @SerializedName("code_desc")
    private String statusCodeDesc;
    @Expose
    @SerializedName("msg")
    private String message;
    @Expose
    @SerializedName("role_value")
    private String roleValue;

    @Expose
    @SerializedName("token")
    private String token;

    @Override
    public String toString() {
        return "LoginResponse{" +
                "statusCode=" + statusCode +
                ", nickname='" + nickname + '\'' +
                ", account='" + account + '\'' +
                ", statusCodeDesc='" + statusCodeDesc + '\'' +
                ", message='" + message + '\'' +
                ", roleValue='" + roleValue + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginResponse that = (LoginResponse) o;

        if (statusCode != that.statusCode) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (statusCodeDesc != null ? !statusCodeDesc.equals(that.statusCodeDesc) : that.statusCodeDesc != null)
            return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (roleValue != null ? !roleValue.equals(that.roleValue) : that.roleValue != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (statusCodeDesc != null ? statusCodeDesc.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (roleValue != null ? roleValue.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getRoleValue() {
        return roleValue;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
