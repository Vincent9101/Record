package com.vincent.system.ui.personal_info;

import com.androidnetworking.error.ANError;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.ChangeInfoRequest;
import com.vincent.system.data.network.model.ChangeInfoResponse;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：15:59
 */
public class PersonalInfoPresenter<V extends PersonalInfoMvpView> extends BasePresenter<V>
        implements PersonalInfoMvpPresenter<V> {
    @Inject
    public PersonalInfoPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void showInfo() {
        getMvpView().showInfo(getDataManager().getRoleValue(),
                getDataManager().getCurrentUserAccount(),
                getDataManager().getCurrentUserName());
    }

    @Override
    public void changeInfo(final String nickname, final String password) {
        getMvpView().showLoading();

        getCompositeDisposable().add(
                getDataManager().doChangeInfo(new ChangeInfoRequest(password, nickname))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<ChangeInfoResponse>() {
                            @Override
                            public void accept(ChangeInfoResponse changeInfoResponse) throws Exception {
                                getDataManager().setCurrentUserName(nickname);
                                if (!isViewAttached()) {
                                    return;
                                }
                                getMvpView().hideLoading();
                                if (changeInfoResponse.getStatusCodeDesc().equals("SUCCESS_CODE"))
                                    showInfo();
                                else
                                    getMvpView().showMessage("出现错误：" + changeInfoResponse.getStatusCodeDesc());


                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                if (!isViewAttached()) {
                                    return;
                                }
                                getMvpView().hideLoading();

                                // handle the login error here
                                if (throwable instanceof ANError) {
                                    ANError anError = (ANError) throwable;
                                    handleApiError(anError);
                                }
                            }
                        }));
    }


}
