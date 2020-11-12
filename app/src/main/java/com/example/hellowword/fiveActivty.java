package com.example.hellowword;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class fiveActivty  extends Activity {
    private ImageView img;
    private EditText edt;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);
        edt = findViewById(R.id.touch);
        img=this.findViewById(R.id.img);
        img.setEnabled(true);
        img.setOnTouchListener(new myOnTouchListener() );
    }
    private  class myOnTouchListener implements View.OnTouchListener{
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            //如果不按压为0，按压松开之后显示时间
            long time = motionEvent.getEventTime()-motionEvent.getDownTime();
            //如果直接传int型，setText会报错,在这里用转换成String类型
            edt.setText(Integer.toString((int)time));
            return true;
        }
    }
}
