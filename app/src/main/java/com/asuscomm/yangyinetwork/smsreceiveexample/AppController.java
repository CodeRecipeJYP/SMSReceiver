package com.asuscomm.yangyinetwork.smsreceiveexample;

import android.app.Application;
import android.content.IntentFilter;
import android.util.Log;

/**
 * Created by jaeyoung on 2017. 4. 5..
 */

public class AppController extends Application {
    private final String TAG = "JYP/"+getClass().getSimpleName();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}
