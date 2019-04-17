package com.vincent.system.ui.assessment;

import com.vincent.system.ui.base.MvpPresenter;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：17:48
 */
public interface AssessmentMvpPresenter<V extends AssessmentMvpView> extends MvpPresenter<V> {
    void getPatientRecord();

    void deletePatientRecord(String id);
}
