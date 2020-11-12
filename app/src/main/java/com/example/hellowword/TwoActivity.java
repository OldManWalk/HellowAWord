package com.example.hellowword;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;


public class TwoActivity extends Activity {
    private Switch swit;
    private ImageView DASIMA;
    private ImageView apple;
    private Button FITCENTER;
    private Button CENTERCROP;
    private Button CENTERINSIDE;
    private Button CENTER;
    private Button FITXY;
    private Button FITSTART;
    private Button FITEND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        apple = (ImageView)findViewById(R.id.apple);
        DASIMA =(ImageView)findViewById(R.id.dasima);

        //设置button按钮

        FITCENTER = (Button)findViewById(R.id.button);
        FITCENTER.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        });


        CENTERCROP = (Button)findViewById(R.id.button2);
        CENTERCROP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        });


        CENTER = (Button)findViewById(R.id.button4);
        CENTER.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.CENTER);
            }
        });

        FITXY = (Button)findViewById(R.id.button5);
        FITXY.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.FIT_XY);
            }
        });

        FITSTART = (Button)findViewById(R.id.button6);
        FITSTART.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.FIT_START);
            }
        });

        FITEND = (Button)findViewById(R.id.button7);
        FITEND.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.FIT_END);
            }
        });

        CENTERINSIDE = (Button)findViewById(R.id.button3);
        CENTERINSIDE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                apple.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        });



        // 设置Switch开关
        swit = (Switch)findViewById(R.id.SW_switch);
        swit.setOnCheckedChangeListener(new OnCheckedChangeListener(){

            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                if (isChecked) {
                    // 开启switch，
                    DASIMA.setImageResource(R.drawable.dark);
                } else {
                    // 关闭swtich，设置提示信息
                    DASIMA.setImageResource(R.drawable.light);

                }
            }
        });

        //设置滚动式图


    }
}
