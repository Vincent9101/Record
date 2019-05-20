package com.vincent.evaluating_system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.vincent.evaluating_system.dao.EntityPatientRecordMapper;
import com.vincent.evaluating_system.entity.EntityUser;
import com.vincent.evaluating_system.entity.patient.EntityPatientRecord;
import com.vincent.evaluating_system.entity.patient.PatientRecordVO;
import com.vincent.evaluating_system.entity.patient.StateTemp;
import com.vincent.evaluating_system.service.EntityPatientRecordService;
import com.vincent.evaluating_system.service.EntityUserService;
import com.vincent.evaluating_system.service.impl.EntityUserServiceImpl;
import com.vincent.evaluating_system.util.PasswordUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvaluatingSystemApplicationTests {
    @Autowired
    EntityPatientRecordService service;

    @Test
    public void testPatientBaseMapper() {


        EntityPatientRecord entityPatientRecord = new EntityPatientRecord();


        StateTemp stateTemp = new StateTemp();
        stateTemp.setFaceState(new ArrayList<String>());
        stateTemp.setFaceStateRemarks("测试");


        for (int i = 30; i > 0; i--) {
            PatientRecordVO patientRecordVO = new PatientRecordVO("22" + i, "55", 99, stateTemp, new Date(), null);
            service.saveOrUpdateOne(patientRecordVO.toEntity());
        }
//        EntityPatientRecord entityPatientRecord2 = service.selectOne(new EntityWrapper<EntityPatientRecord>()
//                .eq("patient_name", "name2"));
//        entityPatientRecord2.blobToStateTemp();
//        System.out.println(entityPatientRecord2);
    }

    @Test
    public void testPwdUtil() {
        String salt = PasswordUtil.generateSalt();
        String pwd = "Vincent";
        String hashPwd = PasswordUtil.generateHashPassword(pwd, salt);
        System.out.print("testPwdUTIL" + PasswordUtil.isRight(salt, hashPwd, pwd));
    }

    @Test
    public void testService() {
        EntityUserService userService = new EntityUserServiceImpl();

        EntityUser list = userService.selectOne(new EntityWrapper<EntityUser>().eq("account", "admin"));
        System.out.print("List 用户" + list);
    }
}
