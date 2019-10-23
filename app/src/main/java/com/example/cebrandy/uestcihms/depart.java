package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class depart extends AppCompatActivity {
    ArrayAdapter adapter;
    List<String> strs=new ArrayList<>();
    List<String> strs2=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.depart);

        init1();
        ListView lv = (ListView) findViewById(R.id.listview_dep);
        adapter =new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strs);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(depart.this,doctor.class);
                intent.putExtra("depart", adapter.getItem(i).toString());
                startActivity(intent);
            }
        });
    }


    void init1() {
        AVQuery<AVObject> query = new AVQuery<>("Doctor");
        query.selectKeys(Arrays.asList("depart"));
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(e==null) {
                    strs.clear();
                    for (AVObject avObject : list) {
                        strs2.add(avObject.getString("depart").toString());
                    }
                    for(String str2 : strs2) {
                        boolean flag=true;
                        for(String str : strs){
                            if(str.equals(str2))
                                flag=false;
                        }
                        if(flag==true)
                            strs.add(str2);
                    }
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
