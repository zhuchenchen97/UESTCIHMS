package com.example.cebrandy.uestcihms;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVCloudQueryResult;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.CloudQueryCallback;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class jianchabaogao extends AppCompatActivity {
    private List<BaoGao> baogaoList=new ArrayList<>();
    private BaoGaoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.jianchabaogao);


        initBaogao();
        adapter=new BaoGaoAdapter(this,R.layout.baogao_item,baogaoList);
        ListView listView=(ListView)findViewById(R.id.baogaoList);
        listView.setAdapter(adapter);

    }

    public void initBaogao()
    {

        AVUser currentUser = AVUser.getCurrentUser();
        AVQuery<AVObject> avQuery = new AVQuery<>("PerInfo");
        avQuery.whereEqualTo("username",currentUser.getUsername());
        avQuery.selectKeys(Arrays.asList("schoolnumber"));
        avQuery.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if (list.size() == 0) {
                    Toast.makeText(jianchabaogao.this, "请先填写个人资料", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(jianchabaogao.this, gerenziliao.class));
                }
                else {
                    String stu_num1 = list.get(0).getString("schoolnumber");
                    AVQuery<AVObject> query = new AVQuery<>("Check");
                    query.selectKeys(Arrays.asList("stu_name", "stu_num", "doc_name", "symptom", "diagnosis", "time", "updatedAt", "objectId"));
                    query.whereEqualTo("stu_num",stu_num1);
                    query.orderByDescending("updatedAt");
                    query.findInBackground(new FindCallback<AVObject>() {
                        @Override
                        public void done(List<AVObject> list, AVException e) {
                            if (list.size() == 0) {
                                Toast.makeText(jianchabaogao.this, "当前无报告", Toast.LENGTH_SHORT).show();
                            }
                            if (e==null) {
                                for (AVObject avObject : list) {

                                    baogaoList.add(new BaoGao(avObject.getString("stu_name"), avObject.getString("stu_num"), avObject.getString("doc_name"), avObject.getString("symptom"), avObject.getString("diagnosis"),avObject.getString("time"), avObject.getObjectId()));
                                }
                                adapter.notifyDataSetChanged();
                            }
                            else {
                                Toast.makeText(jianchabaogao.this, e.toString(), Toast.LENGTH_LONG);
                            }
                        }
                    });
                }
            }
        });
    }


    public void back(View v)
    {
        finish();
    }
}
