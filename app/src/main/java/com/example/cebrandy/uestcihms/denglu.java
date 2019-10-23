package com.example.cebrandy.uestcihms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;

public class denglu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button Login = (Button) findViewById(R.id.login);
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText pwd = (EditText) findViewById(R.id.pwd);



        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameString = name.getText().toString();
                String pwdString = pwd.getText().toString();

                if (nameString.isEmpty()) {
                    Toast.makeText(denglu.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (pwdString.isEmpty()) {
                    Toast.makeText(denglu.this, "请输入密码", Toast.LENGTH_SHORT).show();
                } else {
                    AVUser.logInInBackground(nameString, pwdString, new LogInCallback<AVUser>() {
                        @Override
                        public void done(AVUser avUser, AVException e) {
                            String nameString = name.getText().toString();
                            String pwdString = pwd.getText().toString();
                            if (e == null) {
                                Toast.makeText(denglu.this, "登录成功！", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(denglu.this,MainActivity.class));
                                finish();
                            }
                            else if (e.getCode() == 211) {
                                Toast.makeText(denglu.this, "用户不存在", Toast.LENGTH_SHORT).show();
                            }
                            else if (e.getCode() == 210) {
                                Toast.makeText(denglu.this, "密码错误", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(denglu.this, e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }



    public void register(View v) {
        Toast.makeText(this, "欢迎使用电子科大校医院客户端", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, Register.class));
    }

    public void forgetPwd(View v) {
        startActivity(new Intent(this, wangjimima.class));
    }

    public void back(View v) {
        finish();
    }

}


