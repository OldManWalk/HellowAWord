package com.example.hellowword;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class EleActivity extends Activity {
    private BatteryReceiver receiver = null;
    private Boolean registered = false;
    TextView tv_show = null;
    ToggleButton tb_get = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_ele);
        //获取控件
        tv_show = findViewById(R.id.tv_show);
        tb_get = findViewById(R.id.tb_get);
        receiver = new BatteryReceiver();

        //为ToggleButton控件绑定监听器
        tb_get.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {    // 获取电池电量
                    IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                    // 注册BroadcastReceiver
                    registerReceiver(receiver, filter);
                    registered = true;
                } else {    // 停止获取电池电量
                    unregisterReceiver(receiver);
                    registered = false;
                    tv_show.setText("电量未知");
                }
            }
        });
    }

    //Activity组件进去停止状态前回调该函数
    @Override
    protected void onStop() {
        if (registered)
            unregisterReceiver(receiver);
        super.onStop();
    }

    //以内部类的形式定义一个监听电池电量变化的广播接收器
    private class BatteryReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            // 获得当前电量
            int current = intent.getExtras().getInt("level");
            // 获得总电量
            int total = intent.getExtras().getInt("scale");
            int percent = current * 100 / total;
            tv_show.setText("当前手机电量是：" + percent + "%");
        }
    }
}
