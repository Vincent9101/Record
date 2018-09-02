package com.skyworth.cupwar.Fragments;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CpuUsageInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.skyworth.cupwar.R;
import com.skyworth.cupwar.activity.GameActivity;
import com.skyworth.cupwar.activity.LevelSelectActivity;
import com.skyworth.cupwar.utils.StarUtil;
import com.skyworth.cupwar.utils.skyipc.CupIpcManager;
import com.skyworth.cupwar.utils.skyipc.IpcMsgUtil;
import com.skyworth.framework.skysdk.ipc.SkyApplication;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static android.content.Context.MODE_PRIVATE;

public class LevelSelectFragment extends Fragment implements CupIpcManager.IOnHandlerToAIPaintingListener {

    private static final String TAG = "LevelSelectFragment";

    private static final int CMD_NEXT = 1;

    private int pageID;  //页数v
    private RecyclerView mView;
    private levelAdapter mAdapter;
    private static int countFlag = 1;
    private int[] level_number;
    private Context mContext;
    private static final StarUtil db = new StarUtil();
    private SharedPreferences sp;
    private SharedPreferences sharedPreferences;

    private CupIpcManager cupIpcManager;
//    private IpcMsgUtil ipcMsgUtil = IpcMsgUtil.getInstance();
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            String content = msg.obj.toString();

            try {
                JSONObject json = new JSONObject(content);
                String cmd = json.optString("query");
                switch (cmd) {
                    case "下一个":
//                        ipcMsgUtil.sendTtsReqEvent("null", "好的");
                        mAdapter.position++;
                        mAdapter.notifyDataSetChanged();
//                        sendKeyCode2(KeyEvent.KEYCODE_DPAD_RIGHT);
                        break;
                    case "上一个":
                        sendKeyCode2(KeyEvent.KEYCODE_DPAD_LEFT);
                        break;
                    case "确定":
                        sendKeyCode2(KeyEvent.KEYCODE_ENTER);
                        break;

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    public static LevelSelectFragment newInstance(int id) {
        LevelSelectFragment fragment = new LevelSelectFragment();
        fragment.pageID = id;
        return fragment;
    }

    public LevelSelectFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_select, container, false);

        mContext = getContext();

        Log.i(TAG, "onCreateView: CupIpcManager");


        level_number = new int[3];
        for (int i = 0; i < 3; i++) {
            level_number[i] = countFlag++;
        }
        mView = view.findViewById(R.id.level_recyclerview);

        mAdapter = new levelAdapter();
//        cupIpcManager = CupIpcManager.getInstance(mContext);
//        cupIpcManager.registerOnHandlerListener(this);

        mView.setAdapter(mAdapter);
        mView.setLayoutManager(new GridLayoutManager(mContext, 3));

        sharedPreferences = getContext().getSharedPreferences("highestGrades", MODE_PRIVATE);
        sp = mContext.getSharedPreferences("normal", Context.MODE_PRIVATE);
        // 第一次开始游戏初始化第一关
        for (int i = 0; i < mContext.getResources().getInteger(R.integer.level_counts); i++) {
            if (db.getStars(sp, i + 1) == -1) {
                db.updateOne(sp, i + 1, 0);
            }
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void getContentCallback(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }

        Message message = Message.obtain();
        message.obj = content;
        mHandler.sendMessage(message);
        Log.d(TAG, "getContentCallback: " + content);
    }

    @Override
    public void ttsStateCallback(String id, String state, String content) {

    }

    private void sendKeyCode2(final int keyCode) {
        try {


//            Runtime.getRuntime().exec("input keyevent "+KeyEvent.KEYCODE_BACK);

            String keyCommand = "input keyevent " + keyCode;
            Log.d("sendKeyCode", String.valueOf(keyCode));
            // 调用Runtime模拟按键操作
            Runtime.getRuntime().exec(keyCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDestroy() {
//        cupIpcManager.unregisterOnHandlerListener(this);
        super.onDestroy();

    }

    class levelAdapter extends RecyclerView.Adapter<levelViewHolder> {

        public int position = 1;

        @NonNull

        @Override
        public levelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.level_card, parent, false);
            v.getLayoutParams().height = mView.getHeight();
            v.getLayoutParams().width = mView.getWidth() / 3;
            return new levelViewHolder(v);
        }


        @Override
        public void onBindViewHolder(@NonNull levelViewHolder levelViewHolder, int i) {
            levelViewHolder.bindView(i);
        }


        @Override
        public int getItemCount() {
            return 3;
        }


    }

    // TODO: 2018/8/2 锁住的关卡不设置监听
    class levelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnFocusChangeListener {
        private int level_leaf = 0;
        private int level_label;
        private boolean isLocked = true;
        private ImageView level_number;
        private ImageView level_background;
        private TextView level_descripition;
        private View level_card;

        public levelViewHolder(@NonNull View itemView) {
            super(itemView);
            level_background = itemView.findViewById(R.id.level_background);
            level_number = itemView.findViewById(R.id.level_number);
            level_descripition = itemView.findViewById(R.id.level_description);
            itemView.setOnFocusChangeListener(this);
            itemView.setOnClickListener(this);
            level_card=itemView.findViewById(R.id.level_card);

        }

        public void bindView(int number) {
            level_label = number + 1 + (pageID - 1) * 3;
            level_leaf = db.getStars(sp, level_label);

            Log.i(TAG, "bindView: position - " + mAdapter.position);
            if (level_label == mAdapter.position) {
                level_card.setFocusable(true);
                level_card.setFocusableInTouchMode(true);
                level_card.requestFocus();
            } else {
                level_card.clearFocus();
            }

            //TODO: 设置关卡描述 可能更改关卡初始化enity
            if (level_leaf != -1) {
                isLocked = false;
            }
            InputStream is_number = null;
            InputStream is_background = null;


            try {

                if (!isLocked) {
                    is_number = getContext().getAssets().open("level_" + level_label + ".png");
                    is_background = getContext().getAssets().open("level_background_" + level_leaf + ".png");
                } else {
                    is_background = getContext().getAssets().open("level_locked.png");
                    is_number = null;
                }
                Bitmap bitmap = BitmapFactory.decodeStream(is_background);
                level_background.setImageBitmap(bitmap);
                if (is_number != null) {
                    bitmap = BitmapFactory.decodeStream(is_number);
                    level_number.setImageBitmap(bitmap);
                }



                level_descripition.setVisibility(View.INVISIBLE);
                if((int)sharedPreferences.getFloat(String.valueOf(level_label), 0f)!=0)
                {
                    level_descripition.setText("最高分： " + (int) sharedPreferences.getFloat(String.valueOf(level_label), 0f));

                }

                if (this.level_label == 1) {
                    onFocusChange(itemView, true);
                }
            } catch (Exception ex) {

            } finally {
                try {
                    if (is_number != null)
                        is_number.close();

                    if (is_background != null)
                        is_background.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getContext(), GameActivity.class);
            intent.putExtra(GameActivity.GAME_LEVEL, level_label);
            intent.putExtra(GameActivity.GAME_TYPE, LevelSelectActivity.NORMAL_LEVEL_SELECT);
            startActivity(intent);
        }


        @Override
        public void onFocusChange(View view, boolean b) {


            if (b) {
                   if((int)sharedPreferences.getFloat(String.valueOf(level_label), 0f)!=0) {
                       level_descripition.setVisibility(View.VISIBLE);

                   }  level_descripition.setText("最高分： " + (int) sharedPreferences.getFloat(String.valueOf(level_label), 0f));
            } else {
                level_descripition.setVisibility(View.INVISIBLE);
            }
        }
    }


}