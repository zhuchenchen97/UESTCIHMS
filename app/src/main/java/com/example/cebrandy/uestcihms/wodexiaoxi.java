package com.example.cebrandy.uestcihms;

import android.content.DialogInterface;
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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wodexiaoxi extends AppCompatActivity {
    private List<InnerMessage> innerMessageList=new ArrayList<>();
    private InnerMessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodexiaoxi);

        initMessage();
        adapter=new InnerMessageAdapter(this,R.layout.message_item,innerMessageList);
        ListView listView=(ListView)findViewById(R.id.messageList);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(wodexiaoxi.this);
                dialog.setTitle("提示");
                dialog.setMessage("是否要删除该条信息？");
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        InnerMessage innerMessage=innerMessageList.get(position);
                        AVQuery.doCloudQueryInBackground("delete from Message where objectId='"+innerMessage.getObjectId()+"'", new CloudQueryCallback<AVCloudQueryResult>() {
                            @Override
                            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                                if(e==null)
                                {
                                    innerMessageList.remove(position);
                                    Toast.makeText(wodexiaoxi.this,"删除成功",Toast.LENGTH_SHORT).show();
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMessage();
    }

    private void initMessage()
    {
        AVUser currentUser = AVUser.getCurrentUser();
        AVQuery<AVObject> query1 = new AVQuery<>("Message");
        query1.selectKeys(Arrays.asList("Title", "Content","updatedAt","Object"));
        query1.whereEqualTo("UserName",currentUser.getUsername());

        AVQuery<AVObject> query2 = new AVQuery<>("Message");
        query2.selectKeys(Arrays.asList("Title", "Content","updatedAt","Object"));
        query2.whereEqualTo("UserName","all user");

        AVQuery<AVObject> query = AVQuery.or(Arrays.asList(query1, query2));
        query.orderByDescending("Time");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(list.size()==0)
                {
                    Toast.makeText(wodexiaoxi.this,"当前无消息",Toast.LENGTH_SHORT).show();
                }
                innerMessageList.clear();
                for (AVObject avObject : list) {
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    java.util.Date date=avObject.getDate("updatedAt");
                    String str=sdf.format(date);
                    innerMessageList.add(new InnerMessage(avObject.getString("Title"),avObject.getString("Content"),str,avObject.getObjectId()));
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void back(View v)
    {
        finish();
    }
}
