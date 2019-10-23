package com.example.cebrandy.uestcihms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVObject;

public class yijianfankui4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yijianfankui4);


        Button button = (Button) findViewById(R.id.button_submit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AVObject advice = new AVObject("Advice");// 构建对象
                EditText Fankui=(EditText) findViewById(R.id.edit_yijianfankui);
                String fankui=Fankui.getText().toString();
                advice.put("advice", fankui);// 设置名称
                advice.saveInBackground();
                Toast.makeText(yijianfankui4.this, "提交成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
