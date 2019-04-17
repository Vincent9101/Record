package com.vincent.system.ui.assessment.business;

import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：17:32
 */
public interface AddPatientMvpPresenter<V extends AddPatientMvpView> extends MvpPresenter<V> {
    void addPatientRecord(PatientRecord patientRecord);
}
