package com.example.administrator.weektest07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> list=new ArrayList<String>();
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {//处理子activity返回的参数
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            list.remove(requestCode);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
            listView.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.listview);//数据源


        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("孙六");
        list.add("周八");

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);//lisiview加载数据源
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=list.get(position);
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle=new Bundle();

                bundle.putString("name",name);
                intent.putExtras(bundle);
                startActivityForResult(intent,position);//向子activity传递参数
            }
        };
        listView.setOnItemClickListener(listener);


    }

}
