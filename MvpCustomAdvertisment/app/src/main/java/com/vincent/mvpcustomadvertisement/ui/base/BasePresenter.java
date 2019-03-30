package com.vincent.mvpcustomadvertisement.ui.base;

import com.androidnetworking.error.ANError;
import com.vincent.mvpcustomadvertisement.data.DataManager;
import com.vincent.mvpcustomadvertisement.util.rx.SchedulerProvider;
import io.reactivex.disposables.CompositeDisposable;

import javax.inject.Inject;

/**
 * Created by IDEA on 2019/3/22
 * User: Vincent
 * Time：14:12
 */
public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {
    private static final String TAG = "BasePresenter";

    private V mMvpView;
    private final DataManager dataManger;
    private final SchedulerProvider schedulerProvider;
    private final CompositeDisposable disposable;

    @Inject
    public BasePresenter(DataManager mDataManger, SchedulerProvider schedulerProvider, CompositeDisposable disposable) {
        this.dataManger = mDataManger;
        this.schedulerProvider = schedulerProvider;
        this.disposable = disposable;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;


    }

    @Override
    public void onDetach() {
        disposable.dispose();
        mMvpView = null;

    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManger() {
        return this.dataManger;
    }

    public SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    public CompositeDisposable getDisposable() {
        return disposable;
    }

    @Override
    public void handleApiError(ANError error) {
        if (error == null || error.getErrorBody() == null) {
            getMvpView().onError("Error occur！！！::" + error.getMessage());
            return;
        }
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.onAttach(MvpView) before" +
                    " requesting data to the Presenter");
        }
    }
}
