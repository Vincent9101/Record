package com.vincent.mvpcustomadvertisement.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.Unbinder;
import com.vincent.mvpcustomadvertisement.di.component.ActivityComponent;

/**
 * Created by IDEA on 2019/3/30
 * User: Vincent
 * Time：14:19
 */
public abstract class BaseFragment extends Fragment implements MvpView {
    private BaseActivity baseActivity;
    private Unbinder unbinder;

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();

    }

    public ActivityComponent getActivityComponent() {
        if (baseActivity != null) {
            return baseActivity.getActivityComponent();
        }
        return null;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            this.baseActivity = (BaseActivity) context;
            baseActivity.onFragmentAttached();
        }
    }

    public void setUnBinder(Unbinder unBinder) {
        this.unbinder = unBinder;
    }

    @Override
    public void showLoading() {
        baseActivity.showLoading();


    }

    @Override
    public void hideLoading() {
        baseActivity.hideLoading();

    }

    @Override
    public void openActivityOnTokenExpire() {
        baseActivity.openActivityOnTokenExpire();
    }

    @Override
    public void onError(int resId) {
        baseActivity.onError(resId);
    }

    @Override
    public void onError(String message) {
        baseActivity.onError(message);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUp(view);
    }

    protected  abstract void setUp(View view);

    @Override
    public void showMessage(String message) {
        baseActivity.showMessage(message);
    }

    @Override
    public void showMessage(int resId) {
        baseActivity.showMessage(resId);

    }

    @Override
    public boolean isNetworkConnected() {
        return baseActivity.isNetworkConnected();
    }

    @Override
    public void hideKeyboard() {
        baseActivity.hideKeyboard();

    }

    public interface CallBack {
        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
