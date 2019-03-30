package com.vincent.mvpcustomadvertisement.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.vincent.mvpcustomadvertisement.ui.advertisement.AdvertisementActivity;

/**
 * Created by IDEA on 2019/3/26
 * User: Vincent
 * Time：8:47
 */

/**
 * 开机自启
 */

public class BootReceiver extends BroadcastReceiver {
    static final String action_boot = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("charge start", "启动完成");
        if (intent.getAction().equals(action_boot)) {

            Intent mBootIntent = new Intent(context, AdvertisementActivity.class);

            mBootIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(mBootIntent);
        }

    }
}
