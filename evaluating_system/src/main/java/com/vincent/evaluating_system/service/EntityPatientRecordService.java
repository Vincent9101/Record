package com.vincent.evaluating_system.service;

import com.baomidou.mybatisplus.service.IService;
import com.vincent.evaluating_system.entity.patient.EntityPatientRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：21:08
 */
public interface EntityPatientRecordService extends IService<EntityPatientRecord> {
    void saveOrUpdateOne(EntityPatientRecord patientRecord);

}
