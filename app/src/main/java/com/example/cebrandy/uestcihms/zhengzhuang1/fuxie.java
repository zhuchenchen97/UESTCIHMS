package com.example.cebrandy.uestcihms.zhengzhuang1;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cebrandy.uestcihms.R;

public class fuxie extends AppCompatActivity {
    String zhengzhuang1;
    String zhengzhuang2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zz1_fuxie);
        Intent intent1 = this.getIntent();
        zhengzhuang1=intent1.getStringExtra("zhengzhuang1");
    }

    public void zz1(View v){
        final Button zz2 = (Button) findViewById(R.id.fuzhang);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz2(View v){
        final Button zz2 = (Button) findViewById(R.id.dabianganjie);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz3(View v){
        final Button zz2 = (Button) findViewById(R.id.fuxie);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz4(View v){
        final Button zz2 = (Button) findViewById(R.id.ganglie);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz5(View v){
        final Button zz2 = (Button) findViewById(R.id.dabiandaixie);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz6(View v){
        final Button zz2 = (Button) findViewById(R.id.toubuhunzhang);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz7(View v){
        final Button zz2 = (Button) findViewById(R.id.zhongshangfubushi);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz8(View v){
        final Button zz2 = (Button) findViewById(R.id.zhongfubushi);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz9(View v){
        final Button zz2 = (Button) findViewById(R.id.xiafutong);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

    public void zz10(View v){
        final Button zz2 = (Button) findViewById(R.id.shangfuyintong);
        zhengzhuang2 = zz2.getText().toString();
        Intent intent = new Intent(fuxie.this,zz3_fenxi.class);
        intent.putExtra("zhengzhuang1",zhengzhuang1);
        intent.putExtra("zhengzhuang2",zhengzhuang2);
        startActivity(intent);
    }

}
