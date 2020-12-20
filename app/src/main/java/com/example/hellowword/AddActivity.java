package com.example.hellowword;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private DbOpenHelper dbHelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //获取SQLiteOpenHelper对象
        dbHelper = new DbOpenHelper(this, this.getFilesDir().toString() + "/contacts.db3", 1);
        Button btn_save = findViewById(R.id.btn_save);
        //为“保存”按钮绑定监听器
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_name = findViewById(R.id.et_name);
                EditText et_phone = findViewById(R.id.et_phone);
                String nameStr = et_name.getText().toString();
                String phoneStr = et_phone.getText().toString();
                // 数据库表执行插入语句
                dbHelper.getReadableDatabase().execSQL("insert into contact values(null , ? , ?)",
                        new String[]{nameStr, phoneStr});
                finish();
            }
        });
    }
}
