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

public class wodeyuyue extends AppCompatActivity {
    private List<ReminderMessage> reminderMessageList=new ArrayList<>();
    private ReminderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wodeyuyue);

        initReminder();
        adapter=new ReminderAdapter(this,R.layout.reminder_item,reminderMessageList);
        ListView listView=(ListView)findViewById(R.id.messageList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(wodeyuyue.this);
                dialog.setTitle("提示");
                dialog.setMessage("是否要删除该条提醒？");
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        final ReminderMessage reminderMessage=reminderMessageList.get(position);
                        AVQuery.doCloudQueryInBackground("delete from AppointmentRemind where objectId='"+reminderMessage.getObjectId()+"'", new CloudQueryCallback<AVCloudQueryResult>() {
                            @Override
                            public void done(AVCloudQueryResult avCloudQueryResult, AVException e) {
                                if(e==null)
                                {
                                    reminderMessageList.remove(position);
                                    Toast.makeText(wodeyuyue.this,"删除成功",Toast.LENGTH_SHORT).show();
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

    public void initReminder()
    {
        AVUser currentUser = AVUser.getCurrentUser();
        AVQuery<AVObject> query = new AVQuery<>("AppointmentRemind");
        query.selectKeys(Arrays.asList("Name", "DoctName","Num","stu_tel","doc_tel","TreatDep","ARTime","objectId"));
        query.whereEqualTo("UserName",currentUser.getUsername());
        query.orderByDescending("ARTime");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(list.size()==0)
                {
                    Toast.makeText(wodeyuyue.this,"当前无预约",Toast.LENGTH_SHORT).show();
                }
                if(e==null) {
                    for (AVObject avObject : list) {
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        java.util.Date date=avObject.getDate("ARTime");
                        String str=sdf.format(date);
                        reminderMessageList.add(new ReminderMessage( avObject.getString("TreatDep"), avObject.getString("Name"), avObject.getString("Num"),avObject.getString("stu_tel"),avObject.getString("DoctName"), avObject.getString("doc_tel"),str,avObject.getObjectId()));
                    }
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(wodeyuyue.this,e.toString(),Toast.LENGTH_LONG);
                }
            }
        });
    }

    public void back(View v)
    {
        finish();
    }
}
