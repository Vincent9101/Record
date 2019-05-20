package com.vincent.evaluating_system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vincent.evaluating_system.dao.EntityPatientRecordMapper;
import com.vincent.evaluating_system.entity.patient.EntityPatientRecord;
import com.vincent.evaluating_system.service.EntityPatientRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：21:09
 */
@Service
@Transactional
public class EntityPatientRecordServiceImpl extends ServiceImpl<EntityPatientRecordMapper, EntityPatientRecord>
        implements EntityPatientRecordService {
    @Override
    public void saveOrUpdateOne(EntityPatientRecord patientRecord) {
        baseMapper.saveOrUpdateOne(patientRecord);
    }
}
