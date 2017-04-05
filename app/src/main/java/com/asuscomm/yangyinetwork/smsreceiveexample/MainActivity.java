package com.asuscomm.yangyinetwork.smsreceiveexample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by jaeyoung on 2017. 4. 5..
 */

public class MainActivity extends AppCompatActivity {
    private final String TAG = "JYP/"+getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");
        chkPermission(Manifest.permission.RECEIVE_SMS);
    }

    private void chkPermission(String permission) {
        Log.d(TAG, "chkPermission: ");
        int permissionCheck = ContextCompat.checkSelfPermission(this, permission);

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "chkPermission: Granted");
            return;
        } else {
            Log.d(TAG, "chkPermission: GettingPermission");
            String[] permissions = { permission };
            ActivityCompat.requestPermissions(this, permissions, 1);
        }
    }
}
