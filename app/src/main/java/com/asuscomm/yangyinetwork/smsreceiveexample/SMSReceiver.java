package com.asuscomm.yangyinetwork.smsreceiveexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by jaeyoung on 2017. 4. 5..
 */

public class SMSReceiver extends BroadcastReceiver {
    private final String TAG = "JYP/"+getClass().getSimpleName();

    private final String SMSReceiveAction = "android.provider.Telephony.SMS_RECEIVED";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: ");

        if (SMSReceiveAction .equals(intent.getAction())) {
            Bundle bundle = intent.getExtras();
            Object[] messages = (Object[])bundle.get("pdus");

            for (Object message:messages) {
                SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) message);
                String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                String messageBody = currentMessage.getDisplayMessageBody();
                Log.d(TAG, "onReceive: "+"From : "+phoneNumber +" Body : "+messageBody);
            }
        }
    }

}

