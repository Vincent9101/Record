package com.vincent.system.ui.assessment;

import com.androidnetworking.error.ANError;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.ApiError;
import com.vincent.system.data.network.model.NormalResponse;
import com.vincent.system.data.network.model.patient.DeletePatientRequest;
import com.vincent.system.data.network.model.patient.PatientRecordListResponse;
import com.vincent.system.di.PerActivity;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：17:50
 */
@PerActivity
public class AssessmentPresenter<V extends AssessmentMvpView> extends BasePresenter<V>
        implements AssessmentMvpPresenter<V> {
    @Inject
    public AssessmentPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void getPatientRecord() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().doGetPatientRecord()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PatientRecordListResponse>() {
                    @Override
                    public void accept(PatientRecordListResponse patientRecordListResponse) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (patientRecordListResponse.getStatusCodeDesc().equals("SUCCESS_CODE"))
                            getMvpView().onGetPatientRecord(patientRecordListResponse.getPatientRecordList());
                        else {
                            getMvpView().showMessage("出现错误：" + patientRecordListResponse.getMessage());
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

    @Override
    public void deletePatientRecord(String id) {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().doDeletePatientRecord(new DeletePatientRequest(id))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<NormalResponse>() {
                    @Override
                    public void accept(NormalResponse normalResponse) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (normalResponse.getStatusCodeDesc().equals("SUCCESS_CODE"))
                            getMvpView().onDeleteCompleted();
                        else {
                            getMvpView().showMessage("出现错误：" + normalResponse.getMessage());
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
