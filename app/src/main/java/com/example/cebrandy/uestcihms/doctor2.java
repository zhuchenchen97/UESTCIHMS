package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;

import java.util.ArrayList;
import java.util.List;

public class doctor2 extends AppCompatActivity {
    List<String> strs = new ArrayList<>();
    ArrayAdapter adapter;
    String name;
    String depart;
    String objectId;
    String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor2);
        Intent intent1 = this.getIntent();

        objectId=intent1.getStringExtra("ObjectId");

        init1();

        ListView lv = (ListView) findViewById(R.id.listview_doc);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, strs);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==6)
                {
                    Intent intent =new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+tel));
                    startActivity(intent);
                }
            }
        });

        Button appointment=(Button)findViewById(R.id.appointment);
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(AVUser.getCurrentUser()==null)
                {
                    startActivity(new Intent(doctor2.this,denglu.class));
                }
                else {
                    Intent intent = new Intent(doctor2.this, Appointment.class);
                    intent.putExtra("ObjectId", objectId);
                    startActivity(intent);
                }
            }
        });

    }

    void init1(){
        AVQuery<AVObject> avQuery = new AVQuery<>("Doctor");
        avQuery.getInBackground(objectId, new GetCallback<AVObject>() {
            @Override
            public void done(AVObject avObject, AVException e) {
                if (e == null) {

                    String depart = avObject.getString("depart");
                    String name = avObject.getString("name");
                    String workday = avObject.getString("workday");
                    String sex = avObject.getString("sex");
                    String worktimebegin = avObject.getString("worktimebegin");
                    String worktimeend = avObject.getString("worktimeend");
                    String title = avObject.getString("title");
                    tel = avObject.getString("tel");
                    String add = avObject.getString("add");
                    objectId = avObject.getObjectId();

                    strs.add("姓名：" + name);
                    strs.add("职称：" + title);
                    strs.add("科室：" + depart);
                    strs.add("性别：" + sex);
                    strs.add("工作日：" + workday);
                    strs.add("工作时间：" + worktimebegin + " — " + worktimeend);
                    strs.add("电话：" + tel);
                    strs.add("备注：" + add);
                    adapter.notifyDataSetChanged();
                }

            }
        });
    }
    public void back(View v){finish();}
}
