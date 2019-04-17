package com.vincent.system.ui.user_management;

import com.vincent.system.data.DataManager;
import com.vincent.system.ui.base.BasePresenter;
import com.vincent.system.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/4/13
 * User: Vincent
 * Time：18:51
 */
public class ManagementPresenter<V extends ManagementMvpView> extends BasePresenter<V>
        implements ManagementMvpPresenter<V> {
    @Inject
    public ManagementPresenter(DataManager dataManager, SchedulerProvider schedulerProvider, CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
