package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gerenziliao extends AppCompatActivity {
    List<String> strs = new ArrayList<String>();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenziliao_cebian);
        init();
        ListView lv = (ListView) findViewById(R.id.listview_perinfo);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strs);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(gerenziliao.this, (String) adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void init() {
        AVQuery<AVObject> query = new AVQuery<>("PerInfo");
        query.selectKeys(Arrays.asList("username", "name","schoolnumber", "sex", "grade", "college", "major", "hometown", "email"));
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (e == null) {
                    strs.clear();
                    for (AVObject avObject : list) {
                        //String email = avObject.getString("email");
                        String username = AVUser.getCurrentUser().getUsername();
                        String email = AVUser.getCurrentUser().getEmail();
                        String name = avObject.getString("name");
                        String schoolnumber = avObject.getString("schoolnumber");
                        String sex = avObject.getString("sex");
                        String grade = avObject.getString("grade");
                        String college = avObject.getString("college");
                        String major = avObject.getString("major");
                        String hometown = avObject.getString("hometown");

                        strs.add("用户名： " + username);
                        strs.add("姓名：   " + name);
                        strs.add("学号：   " + schoolnumber);
                        strs.add("性别：   " + sex);
                        strs.add("年级：   " + grade);
                        strs.add("学院：   " + college);
                        strs.add("专业：   " + major);
                        strs.add("家乡：   " + hometown);
                        strs.add("邮箱：   " + email);


                    }
                    adapter.notifyDataSetChanged();
                } else {
                    //e.toString()什么意思？？
                    // Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
                    Toast.makeText(gerenziliao.this, "请填写个人资料", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        init();
    }

    public void edit(View v) {
        startActivity(new Intent(gerenziliao.this,gerenziliaoEditor.class));
    }

    public void back(View v) {
        finish();
    }
}