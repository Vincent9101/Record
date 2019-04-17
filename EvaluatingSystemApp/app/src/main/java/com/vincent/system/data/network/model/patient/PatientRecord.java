package com.vincent.system.data.network.model.patient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：11:28
 */

public class PatientRecord {


    @Expose
    private String patientId;
    @Expose
    private String patientName;
    @Expose
    private int patientAge;
    @Expose
    private StateTemp stateTemp;
    @Expose
    private Date created;   // 创建时间
    @Expose
    private Date updated;// 修改时间


    @Override
    public String toString() {
        return "PatientRecordVO{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", created=" + created +
                ", updated=" + updated +
                ", stateTemp=" + stateTemp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientRecord that = (PatientRecord) o;

        if (patientAge != that.patientAge) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (stateTemp != null ? !stateTemp.equals(that.stateTemp) : that.stateTemp != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return updated != null ? updated.equals(that.updated) : that.updated == null;
    }

    public PatientRecord() {
    }

    public PatientRecord(String patientId, String patientName, int patientAge, StateTemp stateTemp, Date created, Date updated) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.stateTemp = stateTemp;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public int hashCode() {
        int result = patientId != null ? patientId.hashCode() : 0;
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + patientAge;
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        result = 31 * result + (stateTemp != null ? stateTemp.hashCode() : 0);
        return result;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public StateTemp getStateTemp() {
        return stateTemp;
    }

    public void setStateTemp(StateTemp stateTemp) {
        this.stateTemp = stateTemp;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
