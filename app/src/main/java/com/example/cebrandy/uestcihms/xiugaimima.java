package com.example.cebrandy.uestcihms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.RequestPasswordResetCallback;

public class xiugaimima extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpwd);

        Button bt = (Button) findViewById(R.id.reset);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailString = ((EditText) findViewById(R.id.email)).getText().toString();
                if (emailString.isEmpty()) {
                    Toast.makeText(xiugaimima.this, "请输入邮箱地址", Toast.LENGTH_SHORT).show();
                } else {
                    AVUser.requestPasswordResetInBackground(emailString, new RequestPasswordResetCallback() {
                        @Override
                        public void done(AVException e) {
                            if (e == null) {
                                Toast.makeText(xiugaimima.this, "请至邮箱查看重置密码链接", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                            else if (e.getCode() == 205) {
                                Toast.makeText(xiugaimima.this, "邮箱地址不存在", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(xiugaimima.this, e.toString(), Toast.LENGTH_SHORT).show();
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
