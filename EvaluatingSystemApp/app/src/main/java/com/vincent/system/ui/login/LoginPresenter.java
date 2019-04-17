

package com.vincent.system.ui.login;

import android.content.Intent;
import com.androidnetworking.error.ANError;
import com.vincent.system.R;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.LoginRequest;
import com.vincent.system.data.network.model.LoginResponse;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V>
        implements LoginMvpPresenter<V> {

    private static final String TAG = "LoginPresenter";

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String account, String password) {
        //validate account and password
        if (account == null || account.isEmpty()) {
            getMvpView().onError(R.string.empty_email);
            return;
        }
        if (password == null || password.isEmpty()) {
            getMvpView().onError(R.string.empty_password);
            return;
        }
        getMvpView().showLoading();


        getCompositeDisposable().add(
                getDataManager().doServerLoginApiCall(new LoginRequest.ServerLoginRequest(account, password))
                        .subscribeOn(getSchedulerProvider().io())
                        .observeOn(getSchedulerProvider().ui())
                        .subscribe(new Consumer<LoginResponse>() {
                            @Override
                            public void accept(LoginResponse response) throws Exception {
                                getMvpView().hideLoading();
                                if (!isViewAttached()) {
                                    return;
                                }
                                if (response.getAccount() == null || response.getAccount() == "") {
                                    getMvpView().showMessage(response.getMessage());

                                } else if (response.getStatusCodeDesc().equals("SUCCESS_CODE")) {
                                    getDataManager().updateUserInfo(
                                            response.getToken(),
                                            DataManager.LoggedInMode.LOGGED_IN_MODE_SERVER,
                                            response.getNickname(),
                                            response.getAccount(),
                                            response.getRoleValue());

                                    getMvpView().openHomeActivity();

                                } else {
                                    getMvpView().showMessage("出现错误：" + response.getStatusCodeDesc());
                                    return;
                                }


                            }
                        }, new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {

                                if (!isViewAttached()) {
                                    return;
                                }

                                getMvpView().hideLoading();
                                getMvpView().showMessage("出现错误THROWBLE：" +throwable.getMessage());
                                if (throwable instanceof ANError) {
                                    ANError anError = (ANError) throwable;
                                    handleApiError(anError);
                                }
                            }
                        }));
    }

}
