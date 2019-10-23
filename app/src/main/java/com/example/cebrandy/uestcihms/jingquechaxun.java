package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cebrandy.uestcihms.zhengzhuang1.bisai;
import com.example.cebrandy.uestcihms.zhengzhuang1.zz3_fenxi;

public class jingquechaxun extends AppCompatActivity {
    String doc_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jingquechaxun);
    }

    public void finddoctor(View v){
        final EditText dn = (EditText) findViewById(R.id.docname_et);
        doc_name= dn.getText().toString();
        Intent intent = new Intent(jingquechaxun.this,doctor3.class);
        intent.putExtra("doc_name",doc_name);
        startActivity(intent);
    }
}
