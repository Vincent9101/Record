package com.vincent.system.ui.home;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.*;
import com.bumptech.glide.Glide;
import com.vincent.system.R;
import com.vincent.system.ui.assessment.AssessmentActivity;
import com.vincent.system.ui.base.BaseActivity;
import com.vincent.system.ui.login.LoginActivity;
import com.vincent.system.ui.personal_info.PersonalInfoActivity;
import com.vincent.system.ui.user_management.ManagementActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends BaseActivity implements HomeMvpView, NavigationView.OnNavigationItemSelectedListener {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        return intent;
    }

    @Inject
    HomeMvpPresenter<HomeMvpView> homeMvpPresenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.content_banner)
    Banner banner;
    @BindView(R.id.function_evaluating)
    AppCompatButton evaluatingBtn;

    @BindView(R.id.function_admin)
    AppCompatButton chargePersonBtn;

    private AlertDialog.Builder dialogBuilder;
    TextView nicknameTextView;

    TextView accountTextView;
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        homeMvpPresenter.onAttach(this);

        setUp();

    }

    @OnClick(R.id.function_admin)
    void onClickFun(View v) {
        startActivity(ManagementActivity.getStartIntent(this));
    }

    @OnClick(R.id.function_evaluating)
    void onClickAccessSystem(View v) {
        startActivity(AssessmentActivity.getStartIntent(this));
    }

    @Override

    protected void onStart() {
        super.onStart();
        banner.start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!banner.isActivated())
            banner.start();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                Intent upIntent = NavUtils.getParentActivityIntent(this);
                upIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {

                    TaskStackBuilder.create(this)

                            .addNextIntentWithParentStack(upIntent)
                            .startActivities();
                } else {

                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    protected void setUp() {

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        nicknameTextView = navigationView.getHeaderView(0).findViewById(R.id.header_nickname);
        accountTextView = navigationView.getHeaderView(0).findViewById(R.id.header_account);
        homeMvpPresenter.setUserInfoFromData();
        setUpBanner(banner);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homeMvpPresenter.onDetach();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void closeNavigationDrawer() {
        if (drawer != null) {
            drawer.closeDrawer(Gravity.START);
        }
    }

    @Override
    public void onLogOffUser() {
        Toast.makeText(HomeActivity.this, "注销成功", Toast.LENGTH_LONG).show();
        startActivity(LoginActivity.getStartIntent(this));
        finish();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {
            case (R.id.menu_item_logout):
                onClickLogout();
                break;
            case (R.id.menu_item_personal_info):
                startActivity(PersonalInfoActivity.getStartIntent(this));
                break;
            case (R.id.menu_item_logoff):

                dialogBuilder = new AlertDialog.Builder(this).setIcon(R.mipmap.ic_launcher).setTitle("账号注销")
                        .setMessage("注销账号后，账号不可用，是否注销？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                homeMvpPresenter.logOffUser();
                                dialogInterface.dismiss();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                dialogBuilder.create().show();
                closeNavigationDrawer();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUpBanner(Banner banner) {
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {

                switch ((Integer) path) {
                    case 1:
                        imageView.setImageResource(R.mipmap.banner_1);
                        break;
                    case 2:
                        imageView.setImageResource(R.mipmap.banner_2);
                        break;
                    case 3:
                        imageView.setImageResource(R.mipmap.banner_3);
                        break;
                    case 4:
                        imageView.setImageResource(R.mipmap.banner_4);
                        break;
                    case 5:
                        imageView.setImageResource(R.mipmap.banner_5);
                        break;
                }

            }
        });
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(titles);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(20000);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        Log.d(TAG, "bannerStart");
        //banner设置方法全部调用完毕时最后调用
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        banner.setImages(list);

    }

    @Override
    public void setUserInfo(String nickname, String account, boolean isSuper) {
        nicknameTextView.setText(nickname);
        accountTextView.setText(null);
        if (!isSuper)
            chargePersonBtn.setVisibility(View.GONE);
    }

    @Override
    public void onClickLogout() {
        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}
