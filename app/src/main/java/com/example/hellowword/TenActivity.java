package com.example.hellowword;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

public class TenActivity extends AppCompatActivity {
    private DbOpenHelper dbHelper = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activit_ten);
        dbHelper = new DbOpenHelper(this, this.getFilesDir().toString() + "/contacts.db3", 1);

        Button btn_add = findViewById(R.id.btn_add);
        //为“新增联系人”按钮绑定监听器
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TenActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        Button btn_find = findViewById(R.id.btn_find);
        //为“查找”按钮绑定监听器
        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_find = findViewById(R.id.et_find);
                String nameOrPhoneStr = et_find.getText().toString();
                //执行查询操作
                Cursor cursor = dbHelper.getReadableDatabase().rawQuery(
                        "select * from contact where name ==?  or phone==?",
                        new String[]{nameOrPhoneStr, nameOrPhoneStr});
                //显示查询结果
                inflateList(cursor);
            }
        });
    }

    //当前Activity从停止状态再次回到运行状态时，onStart()函数会被回调
    @Override
    protected void onStart() {
        super.onStart();
        Cursor cursor = dbHelper.getReadableDatabase()
                .rawQuery("select * from contact", null);
        inflateList(cursor);
    }

    //把查询结果cursor，填充显示到ListView控件中
    private void inflateList(Cursor cursor) {
        // 填充SimpleCursorAdapter
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                TenActivity.this, R.layout.cell, cursor, new String[]{"name", "phone"},
                new int[]{R.id.tv_Name, R.id.tv_Phone}, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER
        );
        // 显示数据
        ListView lv_show = findViewById(R.id.lv_show);
        lv_show.setAdapter(adapter);
    }

    //当前Activity销毁前onDestroy()函数会被回调
    @Override
   protected void onDestroy() {
        super.onDestroy();
        // 退出程序时关闭MyDatabaseHelper里的SQLiteDatabase
        dbHelper.close();
    }
}
