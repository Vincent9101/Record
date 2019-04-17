package com.vincent.system.ui.assessment.business;

import com.androidnetworking.error.ANError;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.NormalResponse;
import com.vincent.system.data.network.model.patient.AddPatientRequest;
import com.vincent.system.data.network.model.patient.PatientRecord;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/15
 * User: Vincent
 * Time：17:33
 */
public class AddPatientPresenter<V extends AddPatientMvpView> extends BasePresenter<V>
        implements AddPatientMvpPresenter<V> {
    @Inject
    public AddPatientPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void addPatientRecord(PatientRecord patientRecord) {
        getMvpView().showLoading();
        AddPatientRequest addPatientRequest = new AddPatientRequest(
                patientRecord.getPatientId(), patientRecord.getPatientName(),
                patientRecord.getPatientAge(), patientRecord.getStateTemp());

        getCompositeDisposable().add(getDataManager().doAddPatientRecord(addPatientRequest)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<NormalResponse>() {
                    @Override
                    public void accept(NormalResponse response) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (response.getStatusCodeDesc().equals("SUCCESS_CODE")) {

                            getMvpView().onAddSucceeded();
                        } else {
                            getMvpView().showMessage("出现错误：" + response.getStatusCodeDesc());

                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
