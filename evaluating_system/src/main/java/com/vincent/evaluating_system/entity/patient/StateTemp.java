package com.vincent.evaluating_system.entity.patient;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：12:01
 */
@Data
public class StateTemp implements Serializable {
    public long serialVersionUID = 5790743718755930419l;

    private List<String> faceState = new ArrayList<>();
    private String faceStateRemarks;

    private List<String> lipState = new ArrayList<>();
    private String lipStateRemarks;

    private List<String> jointState = new ArrayList<>();
    private String jointStateRemarks;

    private List<String> membraneState = new ArrayList<>();
    private String membraneStateRemarks;

    private List<String> teethState = new ArrayList<>();
    private String teethStateRemarks;

    private List<String> tongueState = new ArrayList<>();
    private String tongueStateRemarks;

    private String softPalateState;
    private String softPalateStateRemarks;

    private String MWSTScore;
    private String MWSTScoreRemarks;

    private String finalDiagnosis;

    public StateTemp() {
    }


    public StateTemp(List<String> faceState,
                     String faceStateRemarks,
                     List<String> lipState,
                     String lipStateRemarks,
                     List<String> jointState,
                     String jointStateRemarks,
                     List<String> membraneState,
                     String membraneStateRemarks,
                     List<String> teethState,
                     String teethStateRemarks,
                     List<String> tongueState,
                     String tongueStateRemarks,
                     String softPalateState,
                     String softPalateStateRemarks,
                     String MWSTScore,
                     String MWSTScoreRemarks,
                     String finalDiagnosis) {
        this.faceState = faceState;
        this.faceStateRemarks = faceStateRemarks;
        this.lipState = lipState;
        this.lipStateRemarks = lipStateRemarks;
        this.jointState = jointState;
        this.jointStateRemarks = jointStateRemarks;
        this.membraneState = membraneState;
        this.membraneStateRemarks = membraneStateRemarks;
        this.teethState = teethState;
        this.teethStateRemarks = teethStateRemarks;
        this.tongueState = tongueState;
        this.tongueStateRemarks = tongueStateRemarks;
        this.softPalateState = softPalateState;
        this.softPalateStateRemarks = softPalateStateRemarks;
        this.MWSTScore = MWSTScore;
        this.MWSTScoreRemarks = MWSTScoreRemarks;
        this.finalDiagnosis = finalDiagnosis;
    }
}
