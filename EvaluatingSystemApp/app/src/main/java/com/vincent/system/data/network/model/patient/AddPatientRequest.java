package com.vincent.system.data.network.model.patient;

import android.os.Build;
import android.support.annotation.RequiresApi;
import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：12:46
 */
public class AddPatientRequest {
    @Expose
    private String patientId;
    @Expose
    private String patientName;
    @Expose
    private int patientAge;
    @Expose
    private String faceState;
    @Expose
    private String faceStateRemarks;

    @Expose
    private String lipState;
    @Expose
    private String lipStateRemarks;

    @Expose
    private String jointState;
    @Expose
    private String jointStateRemarks;

    @Expose
    private String membraneState;
    @Expose
    private String membraneStateRemarks;

    @Expose
    private String teethState;
    @Expose
    private String teethStateRemarks;

    @Expose
    private String tongueState;
    @Expose
    private String tongueStateRemarks;

    @Expose
    private String softPalateState;
    @Expose
    private String softPalateStateRemarks;

    @Expose
    private String MWSTScore;
    @Expose
    private String MWSTScoreRemarks;

    @Expose
    private String finalDiagnosis;


    private String listToString(List<String> list) {
        String res = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            res = res + "," + list.get(i);
        }
        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public AddPatientRequest(String patientId, String patientName, int patientAge, StateTemp stateTemp) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;


            this.faceState = listToString(stateTemp.getFaceState());
        this.faceStateRemarks = stateTemp.getFaceStateRemarks();

        this.finalDiagnosis = stateTemp.getFinalDiagnosis();

        this.lipState = listToString(stateTemp.getLipState());
        this.lipStateRemarks = stateTemp.getLipStateRemarks();

        this.membraneState = listToString(stateTemp.getMembraneState());
        this.membraneStateRemarks = stateTemp.getMembraneStateRemarks();

        this.MWSTScore = stateTemp.getMWSTScore();
        this.MWSTScoreRemarks = stateTemp.getMWSTScoreRemarks();

        this.teethState = listToString(stateTemp.getTeethState());
        this.teethStateRemarks = stateTemp.getTeethStateRemarks();

        this.tongueState = listToString(stateTemp.getTongueState());
        this.tongueStateRemarks = stateTemp.getTongueStateRemarks();

        this.softPalateState = stateTemp.getSoftPalateState();
        this.softPalateStateRemarks = stateTemp.getSoftPalateStateRemarks();

        this.jointState = listToString(stateTemp.getJointState());
        this.jointStateRemarks = stateTemp.getJointStateRemarks();


    }
}
