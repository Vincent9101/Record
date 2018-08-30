package com.skyworth.cupwar.activity;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.Toast;

import com.skyworth.cupwar.Fragments.LevelSelectFragment;
import com.skyworth.cupwar.R;
import com.skyworth.cupwar.utils.skyipc.CupIpcManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LevelSelectActivity extends BaseActivity implements CupIpcManager.IOnHandlerToAIPaintingListener {
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


        cupIpcManager = CupIpcManager.getInstance(this);

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
    protected void onStart() {
        super.onStart();

        cupIpcManager.registerOnHandlerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        cupIpcManager.unregisterOnHandlerListener(this);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void ttsStateCallback(String id, String state, String content) {

    }

    @Override
    public void getContentCallback(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }

        Message message = Message.obtain();
        message.obj = content;
        mHandler.sendMessage(message);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String content = msg.obj.toString();

            try {
                JSONObject json = new JSONObject(content);
                String cmd = json.optString("query");
                switch (cmd) {
                    case "下一个":
                    case "下一关":
                        sendKeyCode2(KeyEvent.KEYCODE_DPAD_RIGHT);
                        break;
                    case "上一个":
                    case "上一关":
                        sendKeyCode2(KeyEvent.KEYCODE_DPAD_LEFT);
                        break;
                    case "确定":
                    case "开始":
                        sendKeyCode2(KeyEvent.KEYCODE_ENTER);
                        break;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private void sendKeyCode2(final int keyCode) {
        try {


            String keyCommand = "input keyevent " + keyCode;
            Log.d("sendKeyCode", String.valueOf(keyCode));
            // 调用Runtime模拟按键操作
            Runtime.getRuntime().exec(keyCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
