package com.vincent.system.data.network.model.patient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：12:47
 */
public class DeletePatientRequest {
    @Expose
    private String patientId;

    public DeletePatientRequest(String patientId) {
        this.patientId = patientId;
    }
}
