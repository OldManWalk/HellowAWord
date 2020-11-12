package com.example.hellowword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class SixActivity02  extends Activity {
    private EditText shengao;
    private EditText xingbie;
    private EditText biaozhu;
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_six02);
    Intent intent=getIntent();
    String heig=intent.getStringExtra("heig");
    shengao = findViewById(R.id.shengao);
    shengao.setText(heig);
    String sex=intent.getStringExtra("sexual");
        xingbie = findViewById(R.id.xingbie);
        xingbie.setText(sex);
        int shengaocm= Integer.parseInt(heig);

        String tizhong = "1";
        int temp;

    if (sex.equals("男")){
                temp = (int) ((shengaocm - 80)*0.7);
    }else{
                 temp = (int) ((shengaocm - 70)*0.6);
    }
               tizhong= String.valueOf(temp);
               biaozhu = findViewById(R.id.biaozhun);
               biaozhu.setText(tizhong);

}

}
