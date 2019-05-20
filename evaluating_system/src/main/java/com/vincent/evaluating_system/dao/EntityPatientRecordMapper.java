package com.vincent.evaluating_system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.vincent.evaluating_system.entity.patient.EntityPatientRecord;
import org.apache.ibatis.annotations.Param;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：21:03
 */
//TODO: 分页
public interface EntityPatientRecordMapper extends BaseMapper<EntityPatientRecord> {
    void saveOrUpdateOne(@Param("patient") EntityPatientRecord patientRecord);
}
