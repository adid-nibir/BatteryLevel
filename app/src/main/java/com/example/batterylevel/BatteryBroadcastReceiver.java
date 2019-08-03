package com.example.batterylevel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BatteryBroadcastReceiver extends BroadcastReceiver {
    private final static String BATTERY_LEVEL = "level";
    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BATTERY_LEVEL, 0);

    }
}
