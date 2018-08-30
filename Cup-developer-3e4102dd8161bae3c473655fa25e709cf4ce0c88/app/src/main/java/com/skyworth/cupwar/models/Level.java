package com.skyworth.cupwar.models;


import android.content.Context;
import android.graphics.Color;

public class Level {
    private int levelId;
    private Water mWater;
    private WarningLine mLine;
    private Timer mTimer;
    private int ScreenH;
    private int ScreenW;

    public Water getWater() {
        return mWater;
    }

    public WarningLine getLine() {
        return mLine;
    }

    public Timer getTimer() {
        return mTimer;
    }

    public Level(Context context, int id, int screenW, int screenH){
        levelId = id;
        mWater = new Water(screenW, screenH);
        mTimer = new Timer(context, screenW, screenH);
        mLine = new WarningLine(context, screenW, screenH);
        ScreenW = screenW;
        ScreenH = screenH;
        setLevelInfor();
    }

    private void setLevelInfor(){
        // 关卡参数
        switch (levelId){
            case 1:
                mLine.setBaseLine(ScreenH/3.2f + 60);
                mLine.setWidth(100);
                break;
            case 2:
                mLine.setBaseLine(ScreenH/3.2f -100);
                mLine.setWidth(75);
                mWater.setColor(Color.argb(255,220,255,255), Color.argb(255,220,255,255)
                );
                break;
            case 3:
                mLine.setBaseLine(ScreenH/3.2f+150);
                mLine.setWidth(75);
                mWater.setColor(Color.argb(255,233,157,5), Color.argb(200,233,157,5));
                break;
            case 4:
                mLine.setBaseLine(ScreenH/3.2f-50);
                mLine.setWidth(60);
                mWater.setBaseline(ScreenH/3.2f+400);
                mWater.setColor(Color.argb(255,250,240,230),Color.argb(200,196,112,55) );
                break;
            case 5:
                mLine.setBaseLine(ScreenH/3.2f+50);
                mLine.setWidth(60);
                mWater.setBaseline(ScreenH/3.2f+400);
                mWater.setColor(Color.argb(92,146,104,67),Color.argb(255,130,184,103) );
                break;
            case 6:
                mLine.setBaseLine(ScreenH/3.2f-100);
                mLine.setWidth(50);
                mWater.setBaseline(ScreenH/3.2f+400);
                mWater.setColor(Color.argb(255,96,35,42),Color.argb(128,180,72,25) );
                break;
        }
    }

}
