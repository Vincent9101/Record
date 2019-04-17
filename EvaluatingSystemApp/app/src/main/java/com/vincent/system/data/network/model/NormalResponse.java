package com.vincent.system.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：14:53
 */
public class NormalResponse {
    @Expose
    @SerializedName("code")
    private int statusCode;
    @Expose
    @SerializedName("code_desc")
    private String statusCodeDesc;
    @Expose
    @SerializedName("msg")
    private String message;

    @Override
    public String toString() {
        return "NormalResponse{" +
                "statusCode=" + statusCode +
                ", statusCodeDesc='" + statusCodeDesc + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NormalResponse that = (NormalResponse) o;

        if (statusCode != that.statusCode) return false;
        if (statusCodeDesc != null ? !statusCodeDesc.equals(that.statusCodeDesc) : that.statusCodeDesc != null)
            return false;
        return message != null ? message.equals(that.message) : that.message == null;
    }

    @Override
    public int hashCode() {
        int result = statusCode;
        result = 31 * result + (statusCodeDesc != null ? statusCodeDesc.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
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

    public NormalResponse(int statusCode, String statusCodeDesc, String message) {
        this.statusCode = statusCode;
        this.statusCodeDesc = statusCodeDesc;
        this.message = message;
    }

    public NormalResponse() {
    }
}
