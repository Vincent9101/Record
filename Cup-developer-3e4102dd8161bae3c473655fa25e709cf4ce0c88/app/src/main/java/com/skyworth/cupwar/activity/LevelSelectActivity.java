package com.skyworth.cupwar.activity;

import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.skyworth.cupwar.Fragments.LevelSelectFragment;
import com.skyworth.cupwar.R;
import com.skyworth.cupwar.utils.skyipc.CupIpcManager;

import java.util.ArrayList;
import java.util.List;

public class LevelSelectActivity extends BaseActivity  {
    public static final String MODE_TYPE = "mode_type";
    public static final int NORMAL_LEVEL_SELECT = 1;
    public static final int CHALLENGE_LEVEL_SELECT = 2;
    private ImageView btn_previous;
    private ImageView btn_next;
    private ViewPager mPager;
    private static int modeType;  // 模式标识
    private CupIpcManager cupIpcManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_select);
        btn_next = findViewById(R.id.btn_next);
        btn_previous = findViewById(R.id.btn_previous);
        mPager = findViewById(R.id.level_menu);
        // 获取模式
        modeType = getIntent().getIntExtra(MODE_TYPE, 0);


//        // 按钮先获取焦点
//        btn_previous.setFocusable(true);
//        btn_previous.requestFocus();
        initViewPager();
    }

    private void initViewPager() {
        List<LevelSelectFragment> fragments = new ArrayList<>();
        int level = getResources().getInteger(R.integer.level_counts);
        for (int i = 1; i <= level / 3; i++) {
            fragments.add(LevelSelectFragment.newInstance(i));
        }
        mPager.setAdapter(new LevelFragmentsAdapter(getSupportFragmentManager(), fragments));

    }

    public int getModeType() {
        return modeType;
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


    class LevelFragmentsAdapter extends FragmentPagerAdapter {
        private List<LevelSelectFragment> mFragments;

        public LevelFragmentsAdapter(FragmentManager manager, List<LevelSelectFragment> fragments) {
            super(manager);
            mFragments = fragments;
        }

        @Override
        public LevelSelectFragment getItem(int i) {
            return mFragments.get(i);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
