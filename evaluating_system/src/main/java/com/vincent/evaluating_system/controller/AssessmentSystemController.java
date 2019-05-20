package com.vincent.evaluating_system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vincent.evaluating_system.entity.patient.EntityPatientRecord;
import com.vincent.evaluating_system.entity.patient.PatientRecordVO;
import com.vincent.evaluating_system.entity.patient.StateTemp;
import com.vincent.evaluating_system.service.EntityPatientRecordService;
import com.vincent.evaluating_system.util.BlobTempUtil;
import com.vincent.evaluating_system.vo.ApiResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.management.Agent;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/7
 * User: Vincent
 * Time：20:09
 */
@Api(tags = "Assessment System ", description = "医疗评估业务部分")
@RestController
@RequestMapping("/api/")
public class AssessmentSystemController {


    @Autowired
    EntityPatientRecordService recordService;

    @DeleteMapping("/patient_record")
    @ApiOperation("删除病人记录")
    public HashMap deletePatientInfo(String patientId) {

        if (recordService.selectById(patientId) == null)
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("该病例不存在！！！")
                    .build();
        boolean ok = recordService.deleteById(patientId);
        if (ok)
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                    .buildResponseMsg("删除成功！")
                    .build();

        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SERVER_ERR_CODE)
                .buildResponseMsg("删除失败！")
                .build();
    }

    @GetMapping ("/patient_record")
    @ApiOperation("查询病人记录")
    public HashMap queryPatientInfo() {

        List<PatientRecordVO> patientRecordVOList = recordService
                .selectList(new EntityWrapper<EntityPatientRecord>().isNotNull("patient_id").orderBy("created", false))
                .stream()
                .map(entityPatientRecord -> entityPatientRecord.toVO())
                .collect(Collectors.toList());

//        System.out.print(patientRecordVOList);
        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .buildResponseMsg("获取成功")
                .builderData("patient_record", patientRecordVOList)
                .build();
    }

    @PostMapping("/patient_record")
    @ApiOperation("录入病人记录")
    public HashMap addPatientInfo(@RequestParam String patientName,
                                  @RequestParam String patientId,
                                  @RequestParam int patientAge,
                                  @RequestParam List<String> faceState,
                                  @RequestParam String faceStateRemarks,  // 4

                                  @RequestParam List<String> lipState,       //2
                                  @RequestParam String lipStateRemarks,

                                  @RequestParam List<String> jointState,    //4
                                  @RequestParam String jointStateRemarks,

                                  @RequestParam List<String> membraneState,  //3
                                  @RequestParam String membraneStateRemarks,

                                  @RequestParam List<String> teethState,  //2
                                  @RequestParam String teethStateRemarks,

                                  @RequestParam List<String> tongueState,  //2
                                  @RequestParam String tongueStateRemarks,

                                  @RequestParam String softPalateState,
                                  @RequestParam String softPalateStateRemarks,

                                  @RequestParam String MWSTScore,
                                  @RequestParam String MWSTScoreRemarks,

                                  @RequestParam String finalDiagnosis) {
        if (StringUtils.isAnyEmpty(patientId, patientName, jointStateRemarks,
                faceStateRemarks, lipStateRemarks, membraneStateRemarks, tongueStateRemarks,
                softPalateState, softPalateStateRemarks, teethStateRemarks, MWSTScoreRemarks, finalDiagnosis)) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，不能有空参数")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (faceState.size() == 0 || teethState.size() == 0 || jointState.size() == 0
                || tongueState.size() == 0 || lipState.size() == 0 || membraneState.size() == 0) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，数组参数不能有空参数")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (faceState.size() != 4) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，faceSate数组参数有且只有4个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }
        if (lipState.size() != 2) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，lipState数组参数有且只有2个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (jointState.size() != 4) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，jointState数组参数有且只有4个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (membraneState.size() != 3) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，membraneState数组参数有且只有3个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (teethState.size() != 2) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，teethState数组参数有且只有2个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        if (tongueState.size() != 2) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("参数有误，tongueState数组参数有且只有2个")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }


        StateTemp stateTemp = new StateTemp();

        stateTemp.setFaceStateRemarks(faceStateRemarks);
//        stateTemp.setFaceState(faceState);

        stateTemp.setFinalDiagnosis(finalDiagnosis);

        stateTemp.setJointState(jointState);
        stateTemp.setJointStateRemarks(jointStateRemarks);

        stateTemp.setLipState(lipState);
        stateTemp.setLipStateRemarks(lipStateRemarks);

        stateTemp.setMembraneState(membraneState);
        stateTemp.setMembraneStateRemarks(membraneStateRemarks);

        stateTemp.setMWSTScore(MWSTScore);
        stateTemp.setMWSTScoreRemarks(MWSTScoreRemarks);

        stateTemp.setTongueStateRemarks(tongueStateRemarks);
        stateTemp.setTongueState(tongueState);

        stateTemp.setSoftPalateState(softPalateState);
        stateTemp.setSoftPalateStateRemarks(softPalateStateRemarks);

        stateTemp.setTeethState(teethState);
        stateTemp.setTeethStateRemarks(teethStateRemarks);


        PatientRecordVO patientRecordVO = new PatientRecordVO(patientId,
                patientName, patientAge,
                stateTemp, new Date(), null);
        recordService.saveOrUpdateOne(patientRecordVO.toEntity());

        return ApiResponseVO.builder()
                .buildResponseMsg("操作成功")
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .build();
    }
}
