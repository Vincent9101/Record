package com.vincent.evaluating_system.entity.patient;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.vincent.evaluating_system.util.BlobTempUtil;
import lombok.Data;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IDEA on 2019/4/8
 * User: Vincent
 * Time：12:59
 */
@Data
@TableName("table_patient")
public class EntityPatientRecord extends Model<EntityPatientRecord> {

    @TableId
    private String patientId;
    @TableField
    private String patientName;
    @TableField
    private int patientAge;
    @TableField
    private byte[] stateBlob;
    @TableField
    private Date created;   // 创建时间
    @TableField
    private Date updated;   // 修改时间

    @Override
    protected Serializable pkVal() {
        return patientId;
    }

    public PatientRecordVO toVO() {
        PatientRecordVO patientRecordVO = new PatientRecordVO(patientId, patientName, patientAge,
                BlobTempUtil.blobToStateTemp(stateBlob),
                created, updated);
        return patientRecordVO;
    }

    public EntityPatientRecord() {
    }

    public EntityPatientRecord(String patientId, String patientName, int patientAge, byte[] stateBlob, Date created, Date updated) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.stateBlob = stateBlob;
        this.created = created;
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "EntityPatientRecord{" +
                "patientId='" + patientId + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientAge=" + patientAge +
                ", stateBlob=" + Arrays.toString(stateBlob) +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntityPatientRecord that = (EntityPatientRecord) o;

        if (patientAge != that.patientAge) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (!Arrays.equals(stateBlob, that.stateBlob)) return false;
        if (created != null ? !created.equals(that.created) : that.created != null) return false;
        return updated != null ? updated.equals(that.updated) : that.updated == null;
    }

    @Override
    public int hashCode() {
        int result = patientId != null ? patientId.hashCode() : 0;
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + patientAge;
        result = 31 * result + Arrays.hashCode(stateBlob);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (updated != null ? updated.hashCode() : 0);
        return result;
    }
}
