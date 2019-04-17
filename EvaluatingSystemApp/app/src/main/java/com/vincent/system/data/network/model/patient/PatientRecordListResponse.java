package com.vincent.system.data.network.model.patient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vincent.system.data.network.model.NormalResponse;

import java.util.List;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：11:37
 */
public class PatientRecordListResponse {
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
    @SerializedName("patient_record")
    private List<PatientRecord> patientRecordList;



    public List<PatientRecord> getPatientRecordList() {
        return patientRecordList;
    }

    public void setPatientRecordList(List<PatientRecord> patientRecordList) {
        this.patientRecordList = patientRecordList;
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
}
