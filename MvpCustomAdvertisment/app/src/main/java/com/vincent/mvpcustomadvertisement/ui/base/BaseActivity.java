package com.vincent.mvpcustomadvertisement.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.Unbinder;
import com.vincent.mvpcustomadvertisement.AdvertisementApp;
import com.vincent.mvpcustomadvertisement.di.component.ActivityComponent;
import com.vincent.mvpcustomadvertisement.di.component.DaggerActivityComponent;
import com.vincent.mvpcustomadvertisement.di.module.ActivityModule;
import com.vincent.mvpcustomadvertisement.util.NetworkUtils;

/**
 * Created by IDEA on 2019/3/21
 * User: Vincent
 * Time：22:42
 */
public abstract class BaseActivity extends AppCompatActivity implements MvpView, BaseFragment.CallBack {


    private ActivityComponent activityComponent;
    private Unbinder mUnBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((AdvertisementApp) getApplication()).getApplicationComponent())
                .build();


    }

    protected abstract void setUp();

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }

    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void hideKeyboard() {

    }

    @Override
    public void showLoading() {
        hideLoading();
    }

    @Override
    public void openActivityOnTokenExpire() {


    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void showMessage(int resId) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isNetworkConnected(getApplicationContext());
    }

    @Override
    public void hideLoading() {


    }
}
