package com.skyworth.cupwar.utils.skyipc;

import android.util.Log;

import com.skyworth.framework.skysdk.ipc.SkyApplication;
import com.skyworth.framework.skysdk.ipc.SkyCmdURI;
import com.skyworth.framework.skysdk.util.SkyData;

import java.net.URISyntaxException;

/**
 * @Class: IpcMsgUtil
 * @Description:发送信息给小维AI
 * @author: sunhong
 * @Date: 2018/7/26 0026
 */
public class IpcMsgUtil {
    private static final String TAG = IpcMsgUtil.class.getSimpleName();
    //协议头
    private static final String cmdHeader = "tianci://com.skyworth.lafite.srtnj.speechserver:SkyLafiteService/com.skyworth.lafite.srtnj.audiorecord.service.SkyLafiteService?cmd=";

    private SkyApplication.SkyCmdConnectorListener listener = null;
    private static IpcMsgUtil instance = null;

    public enum AIPaintingEnum {
        sendTtsReqEvent;
    }

    protected IpcMsgUtil(SkyApplication.SkyCmdConnectorListener listener) {
        this.listener = listener;
    }

    public static IpcMsgUtil getInstance(SkyApplication.SkyCmdConnectorListener listener) {
        Class var1 = IpcMsgUtil.class;
        synchronized (IpcMsgUtil.class) {
            if (null == instance) {
                instance = new IpcMsgUtil(listener);
            }
        }
        return instance;
    }

    public static IpcMsgUtil getInstance() {
        return instance;
    }

    public void ttsHide(boolean isHide) {
        try {
            SkyCmdURI e = new SkyCmdURI(cmdHeader + "hideTts");
            SkyData data = new SkyData();
            data.add("isHide", isHide);
            SkyApplication.getApplication().sendCommand(this.listener, e, data.toBytes());
            Log.d(TAG, "ttsHide:  "+e.getCmdUrl()+ " isHide  " +data.toString());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        } catch (SkyCmdURI.SkyCmdPathErrorException e1) {
            e1.printStackTrace();
        }
    }

    public void sendTtsReqEvent(String id, String text) {
        try {
            SkyCmdURI e = new SkyCmdURI(cmdHeader + AIPaintingEnum.sendTtsReqEvent.toString());
            SkyData data = new SkyData();
            data.add("id", id);
            data.add("content", text);
            SkyApplication.getApplication().sendCommand(this.listener, e, data.toBytes());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        } catch (SkyCmdURI.SkyCmdPathErrorException e1) {
            e1.printStackTrace();
        }
    }
}
