package com.vincent.system.ui.assessment;

import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.ui.base.MvpView;

import java.util.List;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：17:47
 */
public interface AssessmentMvpView extends MvpView {
    void onGetPatientRecord(List<PatientRecord> list);

    void onDeleteCompleted();
}
