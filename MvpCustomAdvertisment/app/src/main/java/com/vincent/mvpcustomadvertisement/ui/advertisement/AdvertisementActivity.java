
package com.vincent.mvpcustomadvertisement.ui.advertisement;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.widget.ImageView;
import android.widget.MediaController;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.vincent.mvpcustomadvertisement.BuildConfig;
import com.vincent.mvpcustomadvertisement.R;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import com.vincent.mvpcustomadvertisement.ui.advertisement.landscape_advertisement.LandscapeAdvertisementFragment;
import com.vincent.mvpcustomadvertisement.ui.advertisement.portrait_advertisement.PortraitAdvertisementFragment;
import com.vincent.mvpcustomadvertisement.ui.base.BaseActivity;
import com.vincent.mvpcustomadvertisement.ui.customview.FullScreenVideoView;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdvertisementActivity extends BaseActivity implements AdvertisementMvpView {
    private final String TAG = "AdvertisementActivity";
    private FragmentManager fragmentManager;
    private Map<String, Object> configMap;
    @Inject
    AdvertisementMvpPresenter<AdvertisementMvpView> advertisementMvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_container);

        Log.d(TAG, "ONCREATE");
        setUnBinder(ButterKnife.bind(this));

        getActivityComponent().inject(this);


        advertisementMvpPresenter.onAttach(this);


        //init
        setUp();
    }


    @Override
    protected void setUp() {
        Log.d(TAG, "SETUP");
        configMap = advertisementMvpPresenter.getSharedPreferensConfig();

        fragmentManager = getSupportFragmentManager();
        if (((AppConstants.WayToPlay) configMap.get(AppConstants.DATA_KEY_WAY_TO_PLAY)).equals(AppConstants.WayToPlay.FIRST_LANDSCAPE)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, LandscapeAdvertisementFragment.newInstance())
                    .commit();
        } else if (((AppConstants.WayToPlay) configMap.get(AppConstants.DATA_KEY_WAY_TO_PLAY)).equals(AppConstants.WayToPlay.SECOND_PORTRAIT)) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, PortraitAdvertisementFragment.newInstance())
                    .commit();
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        advertisementMvpPresenter.onDetach();


    }


    //回调 onResponseReady
    @Override
    public void playAdvertisement(AdvertisementResponse advertisementResponse, Long timeNumber) {

    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, AdvertisementActivity.class);
        return intent;
    }

}
