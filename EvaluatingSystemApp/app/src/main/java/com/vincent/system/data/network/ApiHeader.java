package com.vincent.system.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vincent.system.BuildConfig;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class ApiHeader {
    @Expose
    @SerializedName(BuildConfig.Header)
    private String token;

    @Inject
    public ApiHeader() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiHeader apiHeader = (ApiHeader) o;

        return token != null ? token.equals(apiHeader.token) : apiHeader.token == null;
    }

    @Override
    public int hashCode() {
        return token != null ? token.hashCode() : 0;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
