package com.example.hellowword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SevenActivity  extends Activity {
    private Button xuanze;
    private ImageView imgv;
    private TextView textshow;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);
 textshow=findViewById(R.id.edtext);
        xuanze = findViewById(R.id.xuanze);
        xuanze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend=new Intent(SevenActivity.this,SevenActivity02.class);
                startActivityForResult(intend,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imgv = findViewById(R.id.imgid);
        int imgid = data.getIntExtra("key",0);
        String a= String.valueOf(imgid);
            switch (imgid){
                case 0:
                    imgv.setImageResource(R.drawable.img01);
                    break;
                case 1:
                    imgv.setImageResource(R.drawable.img02);
                    break;
                case 2:
                    imgv.setImageResource(R.drawable.img03);
                    break;
                case 3:
                    imgv.setImageResource(R.drawable.img04);
                    break;
                case 4:
                    imgv.setImageResource(R.drawable.img05);
                    break;
                case 5:
                    imgv.setImageResource(R.drawable.img06);
                    break;
                case 6:
                   imgv.setImageResource(R.drawable.img07);
                    break;
                case 7:
                    imgv.setImageResource(R.drawable.img08);
                    break;
                case 8:
                    imgv.setImageResource(R.drawable.img09);
                    break;

        }
    }
}
