package com.vincent.system.data.network.model.patient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：12:01
 */

public class StateTemp implements Serializable {

    @Expose
    private List<String> faceState = new ArrayList<>();
    ;
    @Expose
    private String faceStateRemarks;

    @Expose
    private List<String> lipState = new ArrayList<>();
    @Expose
    private String lipStateRemarks;

    @Expose
    private List<String> jointState = new ArrayList<>();
    ;
    @Expose
    private String jointStateRemarks;

    @Expose
    private List<String> membraneState = new ArrayList<>();
    ;
    @Expose
    private String membraneStateRemarks;

    @Expose
    private List<String> teethState = new ArrayList<>();
    ;
    @Expose
    private String teethStateRemarks;

    @Expose
    private List<String> tongueState = new ArrayList<>();
    ;
    @Expose
    private String tongueStateRemarks;

    @Expose
    private String softPalateState;
    @Expose
    private String softPalateStateRemarks;

    @Expose
    @SerializedName("mwstscore")
    private String MWSTScore;
    @Expose
    @SerializedName("mwstscoreRemarks")
    private String MWSTScoreRemarks;

    @Expose
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


    public List<String> getFaceState() {
        return faceState;
    }

    public void setFaceState(List<String> faceState) {
        this.faceState = faceState;
    }

    public String getFaceStateRemarks() {
        return faceStateRemarks;
    }

    public void setFaceStateRemarks(String faceStateRemarks) {
        this.faceStateRemarks = faceStateRemarks;
    }

    public List<String> getLipState() {
        return lipState;
    }

    public void setLipState(List<String> lipState) {
        this.lipState = lipState;
    }

    public String getLipStateRemarks() {
        return lipStateRemarks;
    }

    public void setLipStateRemarks(String lipStateRemarks) {
        this.lipStateRemarks = lipStateRemarks;
    }

    public List<String> getJointState() {
        return jointState;
    }

    public void setJointState(List<String> jointState) {
        this.jointState = jointState;
    }

    public String getJointStateRemarks() {
        return jointStateRemarks;
    }

    public void setJointStateRemarks(String jointStateRemarks) {
        this.jointStateRemarks = jointStateRemarks;
    }

    public List<String> getMembraneState() {
        return membraneState;
    }

    public void setMembraneState(List<String> membraneState) {
        this.membraneState = membraneState;
    }

    public String getMembraneStateRemarks() {
        return membraneStateRemarks;
    }

    public void setMembraneStateRemarks(String membraneStateRemarks) {
        this.membraneStateRemarks = membraneStateRemarks;
    }

    public List<String> getTeethState() {
        return teethState;
    }

    public void setTeethState(List<String> teethState) {
        this.teethState = teethState;
    }

    public String getTeethStateRemarks() {
        return teethStateRemarks;
    }

    public void setTeethStateRemarks(String teethStateRemarks) {
        this.teethStateRemarks = teethStateRemarks;
    }

    public List<String> getTongueState() {
        return tongueState;
    }

    public void setTongueState(List<String> tongueState) {
        this.tongueState = tongueState;
    }

    public String getTongueStateRemarks() {
        return tongueStateRemarks;
    }

    public void setTongueStateRemarks(String tongueStateRemarks) {
        this.tongueStateRemarks = tongueStateRemarks;
    }

    public String getSoftPalateState() {
        return softPalateState;
    }

    public void setSoftPalateState(String softPalateState) {
        this.softPalateState = softPalateState;
    }

    public String getSoftPalateStateRemarks() {
        return softPalateStateRemarks;
    }

    public void setSoftPalateStateRemarks(String softPalateStateRemarks) {
        this.softPalateStateRemarks = softPalateStateRemarks;
    }

    public String getMWSTScore() {
        return MWSTScore;
    }

    public void setMWSTScore(String MWSTScore) {
        this.MWSTScore = MWSTScore;
    }

    public String getMWSTScoreRemarks() {
        return MWSTScoreRemarks;
    }

    public void setMWSTScoreRemarks(String MWSTScoreRemarks) {
        this.MWSTScoreRemarks = MWSTScoreRemarks;
    }

    public String getFinalDiagnosis() {
        return finalDiagnosis;
    }

    public void setFinalDiagnosis(String finalDiagnosis) {
        this.finalDiagnosis = finalDiagnosis;
    }


}
