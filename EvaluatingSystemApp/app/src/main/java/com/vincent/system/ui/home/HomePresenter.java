package com.vincent.system.ui.home;

import com.androidnetworking.error.ANError;
import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.NormalResponse;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：13:06
 */
public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V> implements HomeMvpPresenter<V> {

    @Inject
    public HomePresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void setUserInfoFromData() {
        getMvpView().setUserInfo(getDataManager().getCurrentUserName(),
                getDataManager().getCurrentUserAccount(),
                getDataManager().getRoleValue().equals("super"));
    }

    @Override
    public void logOffUser() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager().doLogOff()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<NormalResponse>() {
                    @Override
                    public void accept(NormalResponse normalResponse) throws Exception {

                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (normalResponse.getStatusCodeDesc().equals("SUCCESS_CODE")) {

                            getMvpView().onLogOffUser();
                        } else
                            getMvpView().showMessage("出现错误：" + normalResponse.getStatusCodeDesc());
                        return;
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
