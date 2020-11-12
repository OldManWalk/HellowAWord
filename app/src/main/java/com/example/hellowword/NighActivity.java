package com.example.hellowword;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NighActivity extends Activity {
    private SharedPreferences preferences = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_nigh);
        //获取控件
        //为“参数设置”按钮绑定监听器
        Button btn_set = findViewById(R.id.btn_set);
        btn_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(NighActivity.this, NighActivity02.class);
                startActivity(it);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        preferences = getSharedPreferences("set", Context.MODE_PRIVATE);
        String user = preferences.getString("user", "");
        TextView tv_welcome = findViewById(R.id.tv_welcome);
        tv_welcome.setText("欢迎 " + user + " 来到我的家园");
    }
}
