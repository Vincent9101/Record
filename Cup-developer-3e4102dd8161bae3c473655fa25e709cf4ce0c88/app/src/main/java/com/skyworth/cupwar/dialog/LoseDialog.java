package com.skyworth.cupwar.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.skyworth.cupwar.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoseDialog extends Dialog {

    private TextView failureGrade;
    private TextView grade;
    private ImageView text1;
    private ImageView text2;
    private ImageView text3;
    private ImageView text4;
    private ImageView text5;
    private ImageView text6;
    private ImageView text7;
    private Button replay;
    private Button forgive;
    private int width;
    private int height;
    private LoseControlListener mListener;

    public LoseDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.dialog_lose);
        initView();
    }

    public LoseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        setContentView(R.layout.dialog_lose);
        initView();
    }

    protected LoseDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setContentView(R.layout.dialog_lose);
        initView();
    }

    private void initView() {
        grade=findViewById(R.id.grade);
        grade.setTextColor(Color.rgb(243,240,135));
        failureGrade=findViewById(R.id.failure_grade);
        text1 = findViewById(R.id.text_1);
        text2 = findViewById(R.id.text_2);
        text3 = findViewById(R.id.text_3);
        text4 = findViewById(R.id.text_4);
        text5 = findViewById(R.id.text_5);
        text6 = findViewById(R.id.text_6);
        text7 = findViewById(R.id.text_7);
        replay = findViewById(R.id.btn_again);
        forgive = findViewById(R.id.btn_forgive);
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //重玩
                mListener.onReplay();
            }
        });
        forgive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 取消
                mListener.onForigve();
            }
        });
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.6);
        p.height = (int) (size.y * 0.7);
        getWindow().setAttributes(p);
        width = p.width;
        height = p.height;
        initAnimate();
    }

    // 弹幕效果
    // TODO: 2018/7/29 测试
    private void initAnimate() {
        Animation animate1 = new TranslateAnimation(width + text1.getWidth() + 10, -1000, text1.getY(), text1.getY());
        Animation animate2 = new TranslateAnimation(width + text2.getWidth() + 10, -1200, text2.getY(), text2.getY());
        Animation animate3 = new TranslateAnimation(width + text3.getWidth() + 10, -1500, text3.getY(), text3.getY());
        Animation animate4 = new TranslateAnimation(width + text4.getWidth() + 10, -1000, text4.getY(), text4.getY());
        Animation animate5 = new TranslateAnimation(width + text5.getWidth() + 10, -1000, text5.getY(), text5.getY());
        Animation animate6 = new TranslateAnimation(width + text6.getWidth() + 10, -1200, text6.getY(), text6.getY());
        Animation animate7 = new TranslateAnimation(width + text7.getWidth() + 10, -1000, text7.getY(), text7.getY());

        List<Animation> animationList = new ArrayList<Animation>();
        animationList.addAll(Arrays.asList(new Animation[]{
                animate1,
                animate2,
                animate3,
                animate4,
                animate5,
                animate6,
                animate7
        }));

        List<ImageView> imageViewList = new ArrayList<ImageView>();
        imageViewList.addAll(Arrays.asList(new ImageView[]{
                text1,
                text2,
                text3,
                text4,
                text5,
                text6,
                text7
        }));

        for (int i=0;i<animationList.size();i++) {
            animationList.get(i).setDuration(5000);
            animationList.get(i).setFillAfter(true);
            animationList.get(i).setRepeatCount(Animation.INFINITE);
            animationList.get(i).setInterpolator(new LinearInterpolator());

            imageViewList.get(i).startAnimation(animationList.get(i));
        }
    }




    public void setControlListener(LoseControlListener listener) {
        mListener = listener;
    }

    public void postFailData(int levelId, float time, float grades) {


        failureGrade.setTextColor(Color.rgb(243,240,135));
        failureGrade.setText(String.valueOf((int)grades));


    }

    public interface LoseControlListener {
        void onReplay();

        void onForigve();
    }
}
