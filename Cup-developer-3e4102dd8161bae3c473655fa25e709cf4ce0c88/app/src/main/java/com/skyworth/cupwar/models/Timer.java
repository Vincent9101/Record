package com.skyworth.cupwar.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.io.IOException;
import java.io.InputStream;

public class Timer {
    private static final int LIMIT = 9;  //时间
    private int now;
    private Bitmap background;
    private Bitmap now_number;
    private Paint paint;
    private Rect position;
    private Context mContext;
    private int ScreenW;
    private int ScreenH;

    public Timer(Context context, int screenW, int screenH) {
        now = LIMIT;
        mContext = context;
        paint = new Paint();
        InputStream is = null;
        try {
            is = context.getAssets().open("timer_background.png");
            background = BitmapFactory.decodeStream(is);
        } catch (Exception ex) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                }
            }
        }
        ScreenW = screenW;
        ScreenH = screenH;
        position = new Rect(ScreenW - 50 - background.getWidth(), 50, ScreenW - 50, 50 + background.getHeight());
        // 加载数字
        loadNumber();
    }

    private void loadNumber() {
        InputStream is = null;
        try {
            is = mContext.getAssets().open("timer_" + now + ".png");
            now_number = BitmapFactory.decodeStream(is);
        } catch (Exception ex) {

        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void countDown() {
        now--;
        loadNumber();
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(background, null, position, paint);
        canvas.drawBitmap(now_number, null, position, paint);
    }


}
