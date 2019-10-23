package com.example.cebrandy.uestcihms.zhengzhuang1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.example.cebrandy.uestcihms.InnerMessage;
import com.example.cebrandy.uestcihms.R;
import com.example.cebrandy.uestcihms.Result;
import com.example.cebrandy.uestcihms.ResultAdapter;
import com.example.cebrandy.uestcihms.doctor2;
import com.example.cebrandy.uestcihms.wodexiaoxi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class zz3_fenxi extends AppCompatActivity {
    private List<Result> resultList = new ArrayList<>();
    private ResultAdapter adapter;

   String zhengzhuang1;
   String zhengzhuang2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zz3_fenxi);
        Intent intent1 = this.getIntent();
        zhengzhuang1=intent1.getStringExtra("zhengzhuang1");
        zhengzhuang2=intent1.getStringExtra("zhengzhuang2");

        initresult();
        ListView jg = (ListView) findViewById(R.id.listview_result);
        adapter = new ResultAdapter(this,R.layout.result_item, resultList);
        jg.setAdapter(adapter);
    }

    private void initresult()
    {

        AVQuery<AVObject> query = new AVQuery<>("desease");
        query.selectKeys(Arrays.asList("name", "gailv","zhengzhuang"));
        query.whereEqualTo("zhengzhuang1",zhengzhuang1);
        query.whereEqualTo("zhengzhuang2",zhengzhuang2);
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                if(list.size()==0)
                {
                    Toast.makeText(zz3_fenxi.this,"没有找到对应病症",Toast.LENGTH_SHORT).show();
                }
                resultList.clear();
                for (AVObject avObject : list) {
                    String name = avObject.getString("name");
                    String gailv = avObject.getString("gailv");
                    String zhengzhuang = avObject.getString("zhengzhuang");


                    resultList.add(new Result(name,gailv,zhengzhuang));

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
