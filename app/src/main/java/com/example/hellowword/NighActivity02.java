package com.example.hellowword;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NighActivity02 extends AppCompatActivity {
    private SharedPreferences preferences = null;
    private SharedPreferences.Editor editor = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_nigh02);
        //获取控件
                preferences = getSharedPreferences("set", Context.MODE_PRIVATE);
                //获取haredPreferences.Editor对象，尝试写数据
                editor = preferences.edit();
                //为“确定”按钮绑定监听器

                Button btn_ok = findViewById(R.id.btn_ok);
                final EditText et_user = findViewById(R.id.et_user);
                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user = et_user.getText().toString();
                        editor.putString("user", user);
                        editor.apply();
                        finish();
                    }
                });
            }
        }


