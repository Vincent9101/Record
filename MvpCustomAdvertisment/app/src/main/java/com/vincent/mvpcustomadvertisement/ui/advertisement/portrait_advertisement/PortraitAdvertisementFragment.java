package com.vincent.mvpcustomadvertisement.ui.advertisement.portrait_advertisement;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.MediaController;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.vincent.mvpcustomadvertisement.BuildConfig;
import com.vincent.mvpcustomadvertisement.R;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementRequest;
import com.vincent.mvpcustomadvertisement.data.network.model.AdvertisementResponse;
import com.vincent.mvpcustomadvertisement.di.component.ActivityComponent;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementMvpPresenter;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementMvpView;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementPresenter;
import com.vincent.mvpcustomadvertisement.ui.base.BaseFragment;
import com.vincent.mvpcustomadvertisement.ui.customview.FullScreenVideoView;
import com.vincent.mvpcustomadvertisement.util.AppConstants;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link PortraitAdvertisementFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortraitAdvertisementFragment extends BaseFragment implements AdvertisementMvpView {

    private static final String TAG = "PortraitAdvertisement";

    private int index = 0;
    private AdvertisementResponse response;
    private List<AdvertisementResponse.ResponseVideo> responseVideoList = new ArrayList<>();

    @Inject
    AdvertisementMvpPresenter<AdvertisementMvpView> advertisementMvpPresenter;
    @BindView(R.id.portrait_banner)
    Banner imgBanner;
    @BindView(R.id.portrait_video_view)
    FullScreenVideoView videoView;

    public PortraitAdvertisementFragment() {
        // Required empty public constructor
    }


    public static PortraitAdvertisementFragment newInstance() {
        PortraitAdvertisementFragment fragment = new PortraitAdvertisementFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_portrait_advertisement, container, false);
        ActivityComponent activityComponent = getActivityComponent();
        if (activityComponent != null) {
            activityComponent.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            advertisementMvpPresenter.onAttach(this);
        }
        return view;
    }



    public void playAdvertisement(AdvertisementResponse advertisementResponse, Long timeNumber) {
        response = advertisementResponse;
        Log.d(TAG, "GetsResponse:  " + response);

        imgBanner.update(response.getImgList());

        for (AdvertisementResponse.ResponseVideo responseVideo : response.getVideoList()) {
            for (int i = 0; i < responseVideo.getFrequency(); i++) {
                responseVideoList.add(responseVideo);
            }
        }
        playVideo();

    }


    @Override
    protected void setUp(View view) {
        Log.d(TAG, "PortraitSETUP");
        final AdvertisementRequest advertisementRequest = new AdvertisementRequest(BuildConfig.BASE_URL + BuildConfig.ADVERTISEMENT_JSON_FILE);
        advertisementMvpPresenter.getAdvertisementResponse(advertisementRequest);
        setUpBanner(imgBanner);
        final MediaController mediaController = new MediaController(getContext()) {
            @Override
            protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
                int width = getDefaultSize(0, widthMeasureSpec);
                int height = getDefaultSize(0, heightMeasureSpec);
                setMeasuredDimension(width, height);
            }
        };
        videoView.setMediaController(mediaController);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                index++;
                playVideo();
            }
        });

    }

    private void setUpBanner(Banner banner) {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(String.valueOf(((AdvertisementResponse.ResponseImage) path).getUrl()))
                        .placeholder(R.mipmap.pic_1)
                        .error(R.mipmap.pic_1)
                        .fallback(R.mipmap.pic_1)
                        .into(imageView);
            }
        });
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);

        //设置轮播时间 单位为毫秒
        banner.setDelayTime((Integer) advertisementMvpPresenter.getSharedPreferensConfig().get(AppConstants.DATA_KEY_INTERVAL_TIME)*1000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        Log.d(TAG, "bannerStart");
        //banner设置方法全部调用完毕时最后调用

    }

    private void playVideo() {
        index = index % responseVideoList.size();
        String proxyUrl = ((AdvertisementPresenter) advertisementMvpPresenter).getHttpProxyCacheServer()
                .getProxyUrl(responseVideoList.get(index).getUrl());
        videoView.setVideoPath(proxyUrl);
        if (videoView.isPlaying())
            videoView.stopPlayback();
        videoView.start();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        advertisementMvpPresenter.onDetach();
    }

    @Override
    public void onStart() {
        super.onStart();
        imgBanner.startAutoPlay();
        if (videoView.isPlaying())
            videoView.stopPlayback();
        videoView.start();

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "onResume()");
        videoView.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        videoView.pause();
    }

    @Override
    public void onStop() {
        super.onStop();
        imgBanner.stopAutoPlay();
        videoView.stopPlayback();
    }

}
