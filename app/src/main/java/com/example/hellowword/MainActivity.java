package com.example.hellowword;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv_password;
    private TextView et_password;
    private Button btn_forget;
    private CheckBox ck_remember;
    private RadioGroup rg_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);
        //获取控件
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        btn_forget = findViewById(R.id.btn_forget);
        ck_remember = findViewById(R.id.ck_remember);
        rg_login = findViewById(R.id.rg_login);
        Button bt_next=findViewById(R.id.bt_next);
        Button bt_four=findViewById(R.id.bt_four);
        Button bt_five = findViewById(R.id.bt_five);
        Button bt_six = findViewById(R.id.bt_six);
        Button bt_seven = findViewById(R.id.bt_seven);
        Button bt_eight = findViewById(R.id.bt_eight);
        Button bt_nigh = findViewById(R.id.bt_nigh);
        Button bt_ten = findViewById(R.id.bt_ten);
        Button bt_ele = findViewById(R.id.bt_ele);
        //单选按钮组绑定监听器
        rg_login.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_password) {
                    tv_password.setText("登录密码：");
                    et_password.setHint("请输入密码");
                    btn_forget.setText("忘记密码");
                    ck_remember.setVisibility(View.VISIBLE);
                } else if (checkedId == R.id.rb_verifycode) {
                    tv_password.setText("验证码：");
                    et_password.setHint("请输入验证码");
                    btn_forget.setText("获取验证码");
                    ck_remember.setVisibility(View.INVISIBLE);
                }
            }
        });

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,TwoActivity.class);
                startActivity(intend);
            }
        });

        bt_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,ThreeActivity.class);
                startActivity(intend);
            }
        });
        bt_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,FourActivity.class);
                startActivity(intend);
            }
        });
        bt_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,fiveActivty.class);
                startActivity(intend);
            }
        });
        bt_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,SixActivity.class);
                startActivity(intend);
            }
        });
        bt_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,SevenActivity.class);
                startActivity(intend);
            }
        });
        bt_nigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,NighActivity.class);
                startActivity(intend);
            }
        });
        bt_ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,TenActivity.class);
                startActivity(intend);
            }
        });
        bt_ele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(MainActivity.this,EleActivity.class);
                startActivity(intend);
            }
        });
    }

    }