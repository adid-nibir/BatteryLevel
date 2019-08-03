package com.example.batterylevel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView mBatteryLevelText;
    private ProgressBar mBatteryLevelProgress;
    private com.example.batterylevel.BatteryBroadcastReceiver mReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBatteryLevelText = findViewById(R.id.textView);
        mBatteryLevelProgress = findViewById(R.id.progressBar);
        mReceiver = new BatteryBatteryBroadcastReceiver();
    }

    @Override
    protected void onStart() {
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        new BatteryBroadcastReceiver();
        super.onStart();
    }
    @Override
    protected void onStop() {
        unregisterReceiver(mReceiver);
        super.onStop();
    }
    private class BatteryBatteryBroadcastReceiver extends com.example.batterylevel.BatteryBroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mBatteryLevelText.setText(getString(R.string.battery_level) + " " + level);
            mBatteryLevelProgress.setProgress(level);
        }

    }
}