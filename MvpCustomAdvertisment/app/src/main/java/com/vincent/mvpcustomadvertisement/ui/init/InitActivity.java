package com.vincent.mvpcustomadvertisement.ui.init;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.mvpcustomadvertisement.R;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementActivity;
import com.vincent.mvpcustomadvertisement.ui.base.BaseActivity;
import com.vincent.mvpcustomadvertisement.util.AppConstants;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class InitActivity extends BaseActivity implements View.OnClickListener, InitMvpView {


    @BindView(R.id.btn_setup)
    Button buttonSetup;
    @BindView(R.id.btn_skip)
    Button buttonSkip;
    @BindView(R.id.interval_time_spinner)
    Spinner timeSpinner;
    @BindView(R.id.way_to_play)
    Spinner spinnerWatToPlay;

    @Inject
    InitMvpPresenter<InitMvpView> initMvpViewInitMvpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("请初始化App");

        getActivityComponent().inject(this);
        initMvpViewInitMvpPresenter.onAttach(this);
        setUnBinder(ButterKnife.bind(this));
        if (initMvpViewInitMvpPresenter.isInitialized()) {
            jumpToAdvertisement();
        }
        setUp();
    }

    @Override
    protected void setUp() {
        buttonSetup.setOnClickListener(this);
        buttonSkip.setOnClickListener(this);
        Integer interval[] = new Integer[]{15, 30, 45, 60, 75, 90, 105, 120, 135, 150, 300, 450};
        AppConstants.WayToPlay[] wayToPlays = new AppConstants.WayToPlay[]{AppConstants.WayToPlay.FIRST_LANDSCAPE, AppConstants.WayToPlay.SECOND_PORTRAIT};
        spinnerWatToPlay.setAdapter(new ArrayAdapter<AppConstants.WayToPlay>(this,
                android.R.layout.simple_spinner_dropdown_item,
                wayToPlays));
        timeSpinner.setAdapter(new ArrayAdapter<Integer>(this,
                android.R.layout.simple_spinner_dropdown_item,
                interval));

    }


    @Override
    public void onClick(View v) {
        Map<String, Object> mapSetting = new HashMap<>();
        switch (v.getId()) {
            case R.id.btn_setup:
                mapSetting.put(AppConstants.DATA_KEY_INTERVAL_TIME, (Integer) timeSpinner.getSelectedItem());
                mapSetting.put(AppConstants.DATA_KEY_WAY_TO_PLAY, (AppConstants.WayToPlay) spinnerWatToPlay.getSelectedItem());
                initMvpViewInitMvpPresenter.setUpInit(mapSetting);
                Toast.makeText(this, "设置成功，正在跳转", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_skip:
                mapSetting.put(AppConstants.DATA_KEY_INTERVAL_TIME, (Integer) 30);
                mapSetting.put(AppConstants.DATA_KEY_WAY_TO_PLAY, AppConstants.WayToPlay.SECOND_PORTRAIT);
                initMvpViewInitMvpPresenter.setUpInit(mapSetting);
                Toast.makeText(this, "采用默认设置，正在跳转", Toast.LENGTH_LONG).show();
                break;
        }

        jumpToAdvertisement();
    }

    private void jumpToAdvertisement() {
        Intent intent = AdvertisementActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        initMvpViewInitMvpPresenter.onDetach();
    }

    @Override
    public void callBackForPresenter() {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, InitActivity.class);
        return intent;
    }

}
