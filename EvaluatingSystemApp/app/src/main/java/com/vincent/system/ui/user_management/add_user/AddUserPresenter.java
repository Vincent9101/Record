package com.vincent.system.ui.user_management.add_user;

import com.vincent.system.data.DataManager;
import com.vincent.system.data.network.model.AddUserRequest;
import com.vincent.system.data.network.model.NormalResponse;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/14
 * User: Vincent
 * Time：15:18
 */
public class AddUserPresenter<V extends AddUserMvpView> extends BasePresenter<V>
        implements AddUserMvpPresenter<V> {
    @Inject
    public AddUserPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void doAddUser(String role, String account, String nickname) {
        AddUserRequest addUserRequest = new AddUserRequest();
        addUserRequest.setAccount(account);
        addUserRequest.setRoleValue(role);
        addUserRequest.setNickname(nickname);
        getCompositeDisposable().add(getDataManager().doAddUser(addUserRequest)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<NormalResponse>() {
                    @Override
                    public void accept(NormalResponse normalResponse) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getMvpView().hideLoading();
                        if (!normalResponse.getStatusCodeDesc().equals("SUCCESS_CODE")) {
                            getMvpView().showMessage("出现错误：" + normalResponse.getMessage());
                            return;
                        }
                        getMvpView().onAddSucceeded();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }
}
