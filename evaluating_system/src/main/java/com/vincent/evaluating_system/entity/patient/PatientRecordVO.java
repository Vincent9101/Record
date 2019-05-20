package com.vincent.evaluating_system.entity.patient;

import com.vincent.evaluating_system.util.BlobTempUtil;
import lombok.Data;

import java.util.Date;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：11:57
 */

@Data
public class PatientRecordVO {
    private String patientId;

    private String patientName;

    private int patientAge;

    private StateTemp stateTemp;

    private Date created;   // 创建时间

    private Date updated;// 修改时间

    public PatientRecordVO() {
    }

    public PatientRecordVO(String patientId, String patientName, int patientAge, StateTemp stateTemp, Date created, Date updated) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.stateTemp = stateTemp;
        this.created = created;
        this.updated = updated;
    }

    public EntityPatientRecord toEntity() {
        EntityPatientRecord entityPatientRecord = new EntityPatientRecord(
                patientId, patientName, patientAge,
                BlobTempUtil.stateTempToStateBlob(stateTemp),
                created, updated);
        return entityPatientRecord;
    }

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

        PatientRecordVO that = (PatientRecordVO) o;

        if (patientAge != that.patientAge) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        if (updated != null ? !updated.equals(that.updated) : that.updated != null) return false;
        return stateTemp != null ? stateTemp.equals(that.stateTemp) : that.stateTemp == null;
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
}
