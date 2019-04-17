package com.vincent.system.ui.assessment.business;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.vincent.system.R;
import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.data.network.model.patient.StateTemp;
import com.vincent.system.ui.assessment.AssessmentActivity;
import com.vincent.system.ui.base.BaseActivity;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

public class AddPatientRecordActivity extends BaseActivity implements AddPatientMvpView {

    @Inject
    AddPatientPresenter<AddPatientMvpView> addPatientPresenter;

    @BindView(R.id.input_text_patient_id)
    TextInputEditText inputPatientId;
    @BindView(R.id.input_text_patient_name)
    TextInputEditText inputPatientName;
    @BindView(R.id.input_text_patient_age)
    TextInputEditText inputPatientAge;

    @BindView(R.id.face_spinner_jinluan)
    Spinner faceJinluan;
    @BindView(R.id.face_spinner_mabi)
    Spinner faceMabi;
    @BindView(R.id.face_spinner_yanllian)
    Spinner faceYanlian;
    @BindView(R.id.face_spinner_zuijiao)
    Spinner faceZuijiao;
    @BindView(R.id.input_text_patient_face_state_remark)
    TextInputEditText faceRemark;

    @BindView(R.id.lip_state_spinner_koushao)
    Spinner lipKoushao;
    @BindView(R.id.lip_state_spinner_minzui)
    Spinner lipMinzui;
    @BindView(R.id.input_text_patient_lip_state_remark)
    TextInputEditText lipRemark;

    @BindView(R.id.joint_state_spinner_beidong_kaihe)
    Spinner jointBeidongKaihe;
    @BindView(R.id.joint_state_spinner_beidong_yanmo)
    Spinner jointBeidongYanmo;
    @BindView(R.id.joint_state_spinner_zhudong_kaihe)
    Spinner jointZhudongKaihe;
    @BindView(R.id.joint_state_spinner_zhudong_yanmo)
    Spinner jointZhudonYanmo;
    @BindView(R.id.input_text_patient_joint_state_remark)
    TextInputEditText jointRemark;

    @BindView(R.id.membrane_state_spinner_kuiyang)
    Spinner membraneKuiyang;
    @BindView(R.id.membrane_state_spinner_poshun)
    Spinner membranePosuhn;
    @BindView(R.id.membrane_state_spinner_xuezhong)
    Spinner membraneXuezhong;
    @BindView(R.id.input_text_patient_membrane_state_remark)
    TextInputEditText membraneRemark;

    @BindView(R.id.teeth_state_spinner_quchi)
    Spinner teethQuchi;
    @BindView(R.id.teeth_state_spinner_songdong)
    Spinner teethSongdong;
    @BindView(R.id.input_text_patient_teeth_state_remark)
    TextInputEditText teethRemark;

    @BindView(R.id.softpalate_state_spinner_biqiang)
    Spinner softepalateBiqiang;
    @BindView(R.id.input_text_patient_softpalate_state_remark)
    TextInputEditText softpalateRemark;

    @BindView(R.id.tongue_state_spinner_shenzhan)
    Spinner tongueShenzhan;
    @BindView(R.id.tongue_state_spinner_weijue)
    Spinner tongueWeijue;
    @BindView(R.id.input_text_patient_tongue_state_remark)
    TextInputEditText tongueRemark;

    @BindView(R.id.MWST_spinner)
    Spinner MWSTSpinner;
    @BindView(R.id.input_text_patient_MWST_remark)
    TextInputEditText MWSTRemark;

    @BindView(R.id.input_text_patient_final_diagnosis)
    TextInputEditText finalDiagnosisInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patientrecord);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        addPatientPresenter.onAttach(this);
    }

    @OnClick(R.id.btn_add_patient_record)
    void addPatientRecord() {
        String patientId = inputPatientId.getText().toString();
        String patientName = inputPatientName.getText().toString();
        if (isEmpty(patientId) || isEmpty(patientName) || isEmpty(inputPatientAge.getText().toString())) {
            showMessage("用户信息不能为空");
            return;
        }

        int patientAge = Integer.valueOf(inputPatientAge.getText().toString());
        String[] faceStates = {faceJinluan.getSelectedItem().toString(), faceZuijiao.getSelectedItem().toString(),
                faceMabi.getSelectedItem().toString(), faceYanlian.getSelectedItem().toString()};
        String faceRemarks = faceRemark.getText().toString();

        String[] lipStates = {lipKoushao.getSelectedItem().toString(),
                lipMinzui.getSelectedItem().toString()};
        String lipRemarks = lipRemark.getText().toString();

        String[] tongueStates = {tongueShenzhan.getSelectedItem().toString(),
                tongueWeijue.getSelectedItem().toString()};
        String tongueRemarks = tongueRemark.getText().toString();

        String[] teethStates = {teethQuchi.getSelectedItem().toString(),
                teethSongdong.getSelectedItem().toString()};
        String teethRemarks = teethRemark.getText().toString();

        String softpalateStates = softepalateBiqiang.getSelectedItem().toString();
        String softpalateRemarks = softpalateRemark.getText().toString();

        String[] membraneStates = {membraneKuiyang.getSelectedItem().toString(),
                membranePosuhn.getSelectedItem().toString(),
                membraneXuezhong.getSelectedItem().toString()};
        String membraneRemarks = membraneRemark.getText().toString();

        String[] jointStates = {jointBeidongKaihe.getSelectedItem().toString(),
                jointBeidongYanmo.getSelectedItem().toString(),
                jointZhudongKaihe.getSelectedItem().toString(),
                jointZhudonYanmo.getSelectedItem().toString()};
        String jointRemarks = jointRemark.getText().toString();

        String MWSTScore = MWSTSpinner.getSelectedItem().toString();
        String MWSTRemarks = MWSTRemark.getText().toString();

        String finalDiagnosis = finalDiagnosisInput.getText().toString();

        if (isEmpty(faceRemarks) || isEmpty(lipRemarks) || isEmpty(jointRemarks) || isEmpty(teethRemarks) ||
                isEmpty(tongueRemarks) || isEmpty(membraneRemarks) || isEmpty(softpalateRemarks) || isEmpty(finalDiagnosis)
                || isEmpty(MWSTRemarks)) {
            showMessage("备注诊断信息不能为空！！！");
            return;
        }
        StateTemp stateTemp = new StateTemp(Arrays.asList(faceStates),
                faceRemarks,
                Arrays.asList(lipStates),
                lipRemarks,
                Arrays.asList(jointStates),
                jointRemarks,
                Arrays.asList(membraneStates),
                membraneRemarks,
                Arrays.asList(teethStates),
                teethRemarks,
                Arrays.asList(tongueStates),
                tongueRemarks,
                softpalateStates,
                softpalateRemarks,
                MWSTScore,
                MWSTRemarks,
                finalDiagnosis);
        PatientRecord patientRecord = new PatientRecord(patientId, patientName, patientAge, stateTemp, new Date(), null);
        addPatientPresenter.addPatientRecord(patientRecord);

    }

    private boolean isEmpty(String str) {
        return str == null || str.equals("") || str.length() == 0;
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, AddPatientRecordActivity.class);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        addPatientPresenter.onDetach();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onAddSucceeded() {
        startActivity(AssessmentActivity.getStartIntent(this));
        finish();
    }
}
