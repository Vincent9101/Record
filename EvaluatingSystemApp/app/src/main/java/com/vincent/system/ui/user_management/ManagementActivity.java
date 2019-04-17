package com.vincent.system.ui.user_management;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.vincent.system.R;
import com.vincent.system.ui.base.BaseActivity;

import javax.inject.Inject;

public class ManagementActivity extends BaseActivity implements ManagementMvpView {

    @Inject
    ManagementMvpPresenter<ManagementMvpView> managementMvpViewManagementMvpPresenter;

    private ManagementPagerAdapter mPagerAdapter;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.management_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;


    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ManagementActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        managementMvpViewManagementMvpPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        managementMvpViewManagementMvpPresenter.onDetach();
    }

    @Override
    protected void setUp() {

        mPagerAdapter = new ManagementPagerAdapter(getSupportFragmentManager());
        mPagerAdapter.setTabCount(3);
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText("管理员"));
        mTabLayout.addTab(mTabLayout.newTab().setText("普通用户"));
        mTabLayout.addTab(mTabLayout.newTab().setText("添加用户"));


        mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}
