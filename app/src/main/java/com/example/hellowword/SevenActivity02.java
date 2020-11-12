package com.example.hellowword;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class SevenActivity02 extends Activity {
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight02);
        mContext = SevenActivity02.this;
        grid_photo = (GridView) findViewById(R.id.grid_photo);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.drawable.img01, "图标1"));
        mData.add(new Icon(R.drawable.img02, "图标2"));
        mData.add(new Icon(R.drawable.img03, "图标3"));
        mData.add(new Icon(R.drawable.img04, "图标4"));
        mData.add(new Icon(R.drawable.img05, "图标5"));
        mData.add(new Icon(R.drawable.img06, "图标6"));
        mData.add(new Icon(R.drawable.img07, "图标7"));
        mData.add(new Icon(R.drawable.img08, "图标8"));
        mData.add(new Icon(R.drawable.img09, "图标9"));
        mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("key", position);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });


    }
    }
