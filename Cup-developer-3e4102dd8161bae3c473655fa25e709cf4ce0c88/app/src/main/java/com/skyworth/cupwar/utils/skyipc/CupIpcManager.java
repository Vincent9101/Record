package com.skyworth.cupwar.utils.skyipc;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.skyworth.framework.skysdk.ipc.SkyCmdProcessInstance;
import com.skyworth.framework.skysdk.ipc.SkyContext;
import com.skyworth.framework.skysdk.util.SkyData;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class: CupIpcManager
 * @Description:
 * @author: sunhong
 * @Date: 2018/7/26 0026
 */
public class CupIpcManager implements SkyCmdProcessInstance.SkyCmdProcessInstanceListener {
    private static final String TAG = CupIpcManager.class.getSimpleName();
    private static CupIpcManager instance = null;
    private IOnHandlerToAIPaintingListener mOnHandlerListener;
    private Context mContext;
    private SkyCmdProcessInstance mSkyCmdProcessInstance;
    private List<OnVoiceInputListener> mList;

    /**
     * 接收语音指令
     */
    public interface IOnHandlerToAIPaintingListener {
        void ttsStateCallback(String id, String state,String content);
        void getContentCallback(String content);
    }

    public interface OnVoiceInputListener {
        void onVoiceInput(String text);
    }

    public void addOnVoiceInputListener(OnVoiceInputListener listener) {
        if (mList == null) {
            mList = new ArrayList<>();
        }

        mList.add(listener);
    }

    public void removeOnVoiceInputListener(OnVoiceInputListener listener) {
        if (mList != null) {
            mList.remove(listener);
        }
    }

    public void registerOnHandlerListener(IOnHandlerToAIPaintingListener onHandlerListener) {
        if (mOnHandlerListener != onHandlerListener) {
            mOnHandlerListener = onHandlerListener;
        }
    }

    public void unregisterOnHandlerListener(IOnHandlerToAIPaintingListener onHandlerListener) {
        if (mOnHandlerListener == onHandlerListener) {
            mOnHandlerListener = null;
        }
    }

    private CupIpcManager(Context context) {
        mContext = context;
        mSkyCmdProcessInstance = SkyCmdProcessInstance.getCmdProcessInstance(context.getApplicationContext(), this);
    }

    public static CupIpcManager getInstance(Context context) {
        synchronized (CupIpcManager.class) {
            if (null == instance) {
                instance = new CupIpcManager(context);
            }
        }
        return instance;
    }

    /**
     * 接收其它进程发送的命令
     *
     * @param fromtarget
     * @param cmd
     * @param bytes
     * @return
     */
    @Override
    public byte[] onHandler(String fromtarget, String cmd, byte[] bytes) {
        Log.d(TAG, "from header : " + fromtarget + " cmd : " + cmd );

//        if (mList != null) {
//            for (OnVoiceInputListener listener : mList) {
//                listener.onVoiceInput("666");
//            }
        // TODO 这里按照数据进行判断
//            for (OnVoiceInputListener listener : mList) {
//                listener.onVoiceInput("");
//            }
//        }

        try {
            if (mOnHandlerListener != null) {
                if ("TtsCallBack".equalsIgnoreCase(cmd)) {
                    if (bytes != null) {
                        SkyData skyData = new SkyData(bytes);
                        String id = skyData.getString("id");
                        String state = skyData.getString("state");
                        String content = skyData.getString("value");
                        Log.d(TAG, "tts status callback---" + "id:" + id + "---status" + state);

                        if ("end".equalsIgnoreCase(state)) {
                            mOnHandlerListener.ttsStateCallback(id, state,content);
                        }
                    }
                } else if ("cupwar".equalsIgnoreCase(cmd)) {
                    if (bytes != null) {
                        SkyData skyData = new SkyData(bytes);
                        String content = skyData.getString("value");
                        Log.d(TAG, "cupwar   content "+  content);
//                        mOnHandlerListener.getContentCallback(content);

                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void onResult(String s, String s1, byte[] bytes) {
        Log.d(TAG, "onResult s=" + s + ", s1= " + s1);
    }

    @Override
    public String getCmdClassName() {
        return getClass().getName();
    }

    @Override
    public byte[] requestPause(String s, String s1, byte[] bytes) {
        return new byte[0];
    }

    @Override
    public byte[] requestResume(String s, String s1, byte[] bytes) {
        return new byte[0];
    }

    @Override
    public byte[] requestRelease(String s, String s1, byte[] bytes) {
        return new byte[0];
    }

    @Override
    public byte[] requestStartToVisible(String s, String s1, byte[] bytes) {
        return new byte[0];
    }

    @Override
    public byte[] requestStartToForground(String s, String s1, byte[] bytes) {
        return new byte[0];
    }

    @Override
    public void onCmdConnectorInit() {
        SkyContext.setCmdConnectorListener(this);
    }
}
