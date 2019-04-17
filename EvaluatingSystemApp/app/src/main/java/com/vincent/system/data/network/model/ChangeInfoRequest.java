package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：18:08
 */
public class ChangeInfoRequest {
    @Expose
    @SerializedName("password")
    private String password;
    @Expose
    @SerializedName("nickname")
    private String nickname;

    public ChangeInfoRequest(String password, String nickname) {
        this.password = password;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "ChangeInfoRequest{" +
                "password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeInfoRequest that = (ChangeInfoRequest) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return nickname != null ? nickname.equals(that.nickname) : that.nickname == null;
    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        return result;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
