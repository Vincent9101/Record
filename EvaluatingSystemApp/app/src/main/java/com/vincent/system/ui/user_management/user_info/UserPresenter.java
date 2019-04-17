package com.vincent.system.ui.user_management.user_info;

import com.androidnetworking.error.ANError;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.UserInfoResponse;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

import static com.vincent.system.ui.user_management.user_info.UserFragment.*;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：21:24
 */
public class UserPresenter<V extends UserMvpView> extends BasePresenter<V>
        implements UserMvpPresenter<V> {

    @Inject
    public UserPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void doGetUserInfo(final int userType) {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().doGetUserInfo()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<UserInfoResponse>() {
                    @Override
                    public void accept(UserInfoResponse userInfoResponse) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (!userInfoResponse.getStatusCodeDesc().equals("SUCCESS_CODE")) {
                            getMvpView().showMessage("出现错误：" + userInfoResponse.getStatusCodeDesc());
                            return;
                        }
                        switch (userType) {
                            case UserFragment.NORMAL:
                                getMvpView().updateUserInfos(userInfoResponse
                                        .getNormalUserInfoList());
                                break;
                            case UserFragment.SUPER:
                                getMvpView().updateUserInfos(userInfoResponse.getSuperUserInfoList());
                                break;
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
                })
        );
    }
}
