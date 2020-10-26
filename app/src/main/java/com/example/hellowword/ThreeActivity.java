package com.example.hellowword;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeActivity extends AppCompatActivity {
    private ListView mListView;
    //行星名字
    private String[] names = new String[]{"水星", "金星", "火星", "木星", "土星"};
    //行星描述
    private String[] descs = new String[]{
            "水星是太阳系八大行星最内侧也是最小的一颗行星，也是离太阳最近的行星。",
            "金星是太阳系八大行星之一，排行第二，距离太阳0.725天文单位。",
            "地球是太阳系八大行星之一，排行第三，也是太阳系中直径、质量和密度最大的类地行星。",
            "火星是太阳系八大行星之一，排行第四，属于类地行星，直径约为地球的53%。",
            "木星是太阳系八大行星中体积最大、自转最快的行星，排行第五。它的质量为太阳的千分之一。",
            "土星为太阳系八大行星之一，排行第六，体积仅次于木星。"};
    //行星图片
    private int[] icons = new int[]{R.drawable.shuixing, R.drawable.jinxing,
             R.drawable.huoxing, R.drawable.muxing, R.drawable.tuxing};

    List<Map<String,Object>> ListItems=new ArrayList<Map<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem=new HashMap<String,Object>();
            listItem.put("icon",icons[i]);
            listItem.put("desc",descs[i]);
            listItem.put("name",names[i]);

            //加入list集合
            ListItems.add(listItem);
        }
        ListView list=(ListView)findViewById(R.id.lv);
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,ListItems,
                R.layout.list_item,new String[]{"icon","desc","name"},
                new int[]{R.id.icon,R.id.desc,R.id.name});

        //为ListView设置Adapter
        list.setAdapter(simpleAdapter);



        //选中函数
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                System.out.println(names[position]+"选中");
            }
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

    }

}
