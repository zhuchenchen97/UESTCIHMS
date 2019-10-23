package com.example.cebrandy.uestcihms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

import java.util.Date;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button bt=(Button)findViewById(R.id.registerButton);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nameString=((EditText)findViewById(R.id.name)).getText().toString();
                String pwdString =((EditText)findViewById(R.id.pwd)).getText().toString();
                String repwdString =((EditText)findViewById(R.id.repeatPwd)).getText().toString();
                String emailString =((EditText)findViewById(R.id.email)).getText().toString();
                if(nameString.isEmpty())
                {
                    Toast.makeText(Register.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
                }
                else if (pwdString.isEmpty())
                {
                    Toast.makeText(Register.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                }
                else if(!pwdString.equals(repwdString))
                {
                    Toast.makeText(Register.this,"两次输入密码不相同",Toast.LENGTH_SHORT).show();
                }
                else if(!(emailString.contains("@")&&emailString.contains(".")))
                {
                    Toast.makeText(Register.this,"邮箱地址格式错误",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AVUser user = new AVUser();// 新建 AVUser 对象实例
                    user.setUsername(nameString);// 设置用户名
                    user.setPassword(pwdString);// 设置密码
                    user.setEmail(emailString);// 设置邮箱
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                Toast.makeText(Register.this,"注册成功",Toast.LENGTH_SHORT).show();
                                AVObject AddMessage = new AVObject("Message");// 构建对象
                                AddMessage.put("UserName", nameString);// 设置名称
                                AddMessage.put("Time", new Date());// 设置优先级
                                AddMessage.put("Title", "欢迎注册");
                                AddMessage.put("Content", "感谢使用电子科大附属医院客户端。");
                                AddMessage.saveInBackground();// 保存到服务端
                                finish();
                            }
                            else {
                                switch (e.getCode())
                                {
                                    case 202:
                                        Toast.makeText(Register.this,"用户名已被注册",Toast.LENGTH_SHORT).show();
                                        break;
                                    case 203:
                                        Toast.makeText(Register.this,"邮箱已被注册",Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        Toast.makeText(Register.this,e.toString(),Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
            }
        });
    }
    public void back(View v) {
        finish();
    }
}

