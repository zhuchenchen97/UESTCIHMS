package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class doctor extends AppCompatActivity {
    List<String> strs = new ArrayList<String>();
    List<String> strs2 = new ArrayList<String>();
    ArrayAdapter adapter;
    String depart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor);

        Intent intent1 = this.getIntent();
        depart = intent1.getStringExtra("depart");

        init1();////what
        ListView lv = (ListView) findViewById(R.id.listview_doc);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strs2);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(doctor.this, doctor2.class);
                intent.putExtra("ObjectId",strs.get(i));
                startActivity(intent);
            }
        });
    }

    void init1() {
        AVQuery<AVObject> query = new AVQuery<>("Doctor");
        query.whereContains("depart", depart);

        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    strs.clear();
                    for (AVObject avObject : list) {
                        strs2.add(avObject.getString("name").toString());
                        strs.add(avObject.getObjectId());
                    }
                    if(strs.size()==0)
                        Toast.makeText(doctor.this,"没有找到医生信息",Toast.LENGTH_SHORT);
                    adapter.notifyDataSetChanged();
                }
                else
                    Toast.makeText(doctor.this,"查找医生出错",Toast.LENGTH_SHORT);
            }
        });
    }
    public void back(View v){finish();}
}
