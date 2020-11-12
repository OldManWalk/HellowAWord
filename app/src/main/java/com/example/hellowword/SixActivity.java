package com.example.hellowword;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SixActivity extends Activity {
    private EditText heigh;
    private RadioGroup sexual;
    private Button sendto;
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_six);
        heigh = findViewById(R.id.heigh);
        sexual = findViewById(R.id.sexual);
        sendto = findViewById(R.id.sendto);
        sendto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SixActivity.this,SixActivity02.class);
                int id = sexual.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton)findViewById(sexual.getCheckedRadioButtonId());
                String sex = radioButton.getText().toString();
                String height= heigh.getText().toString();
                intent.putExtra("sexual", sex);
                intent.putExtra("heig", height);
                startActivity(intent);

            }
        });
    }
}
