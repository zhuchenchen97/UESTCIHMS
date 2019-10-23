package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cebrandy.uestcihms.zhengzhuang1.bisai;
import com.example.cebrandy.uestcihms.zhengzhuang1.exin;
import com.example.cebrandy.uestcihms.zhengzhuang1.fali;
import com.example.cebrandy.uestcihms.zhengzhuang1.kesou;
import com.example.cebrandy.uestcihms.zhengzhuang1.fare;
import com.example.cebrandy.uestcihms.zhengzhuang1.futong;
import com.example.cebrandy.uestcihms.zhengzhuang1.fuxie;
import com.example.cebrandy.uestcihms.zhengzhuang1.erming;
import com.example.cebrandy.uestcihms.zhengzhuang1.bianmi;


public class zhinengdaozhen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zhinengdaozhen);

    }

    public void bisai(View v){
        final Button bisai = (Button) findViewById(R.id.bisai);
//        String zhengzhuang1 = bisai.getText().toString();
        String zhengzhuang1 = "鼻塞";
        Intent intent = new Intent(zhinengdaozhen.this,bisai.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void bianmi(View v){
        final Button bianmi = (Button) findViewById(R.id.bianmi);
        String zhengzhuang1 = bianmi.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,bianmi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void exin(View v){
        final Button exin = (Button) findViewById(R.id.exin);
        String zhengzhuang1 = exin.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this, exin.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void fali(View v){
        final Button fali = (Button) findViewById(R.id.fali);
        String zhengzhuang1 = fali.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,fali.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void fare(View v){
        final Button fare = (Button) findViewById(R.id.fare);
        String zhengzhuang1 = fare.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,fare.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void kesou(View v){
        final Button kesou = (Button) findViewById(R.id.kesou);
        String zhengzhuang1 = kesou.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,kesou.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void futong(View v){
        final Button futong = (Button) findViewById(R.id.futong);
        String zhengzhuang1 = futong.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,futong.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void fuxie(View v){
        final Button fuxie = (Button) findViewById(R.id.fuxie);
        String zhengzhuang1 = fuxie.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,fuxie.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }

    public void erming(View v){
        final Button erming = (Button) findViewById(R.id.erming);
        String zhengzhuang1 = erming.getText().toString();
        Intent intent = new Intent(zhinengdaozhen.this,erming.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        startActivity(intent);
    }


}
