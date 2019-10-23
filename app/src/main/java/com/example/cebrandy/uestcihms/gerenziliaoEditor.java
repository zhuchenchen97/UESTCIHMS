package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.LogUtil;
import com.avos.avoscloud.SaveCallback;

import java.util.List;

public class gerenziliaoEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gerenziliaoeditor);

        Button button_add=(Button)findViewById(R.id.button_perinfo_update);

        AVQuery<AVObject> query = new AVQuery<>("PerInfo");
        query.findInBackground(new FindCallback<AVObject>() {
            @Override
            public void done(List<AVObject> list, AVException e) {
                int count=0;
                for (AVObject todo : list) {
                    count++;
                    if(count==1) {
                        String name2 = todo.getString("name");
                        ((EditText) findViewById(R.id.per_info_name_et)).setText(name2);
                        Toast.makeText(gerenziliaoEditor.this, name2, Toast.LENGTH_LONG);
                        String schoolnumber2 = todo.getString("schoolnumber");
                        ((EditText) findViewById(R.id.per_info_schoolnumber_et)).setText(schoolnumber2);
                        String sex2 = todo.getString("sex");
                        ((EditText) findViewById(R.id.per_info_sex_et)).setText(sex2);
                        String grade2 = todo.getString("grade");
                        ((EditText) findViewById(R.id.per_info_grade_et)).setText(grade2);
                        String college2 = todo.getString("college");
                        ((EditText) findViewById(R.id.per_info_college_et)).setText(college2);
                        String major2 = todo.getString("major");
                        ((EditText) findViewById(R.id.per_info_major_et)).setText(major2);
                        String hometown2 = todo.getString("hometown");
                        ((EditText) findViewById(R.id.per_info_hometown_et)).setText(hometown2);

                    }
                    else
                        break;
                }
            }
        });

        button_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AVQuery<AVObject> query = new AVQuery<>("PerInfo");
                query.findInBackground(new FindCallback<AVObject>() {
                    @Override
                    public void done(List<AVObject> list, AVException e) {
                        if (list.isEmpty()) {//空返回1吗？？
                            String name = ((EditText) findViewById(R.id.per_info_name_et)).getText().toString();
                            String schoolnumber = ((EditText) findViewById(R.id.per_info_schoolnumber_et)).getText().toString();
                            String sex = ((EditText) findViewById(R.id.per_info_sex_et)).getText().toString();
                            String grade = ((EditText) findViewById(R.id.per_info_grade_et)).getText().toString();
                            String college = ((EditText) findViewById(R.id.per_info_college_et)).getText().toString();
                            String major = ((EditText) findViewById(R.id.per_info_major_et)).getText().toString();
                            String hometown = ((EditText) findViewById(R.id.per_info_hometown_et)).getText().toString();
                            String username= AVUser.getCurrentUser().getUsername();
                            AVObject textObject = new AVObject("PerInfo");
                            textObject.put("name", name);
                            textObject.put("username", username);
                            textObject.put("schoolnumber", schoolnumber);
                            textObject.put("sex", sex);
                            textObject.put("grade", grade);
                            textObject.put("college", college);
                            textObject.put("major", major);
                            textObject.put("hometown", hometown);
                            textObject.saveInBackground();
                        }
                        else if (list.size() == 1) {
                            String objectId = list.get(0).getObjectId();
                            String name = ((EditText) findViewById(R.id.per_info_name_et)).getText().toString();
                            String schoolnumber = ((EditText) findViewById(R.id.per_info_schoolnumber_et)).getText().toString();
                            String sex = ((EditText) findViewById(R.id.per_info_sex_et)).getText().toString();
                            String grade = ((EditText) findViewById(R.id.per_info_grade_et)).getText().toString();
                            String college = ((EditText) findViewById(R.id.per_info_college_et)).getText().toString();
                            String major = ((EditText) findViewById(R.id.per_info_major_et)).getText().toString();
                            String hometown = ((EditText) findViewById(R.id.per_info_hometown_et)).getText().toString();
                            String username= AVUser.getCurrentUser().getUsername();

                            if (name.length() != 0 || sex.length() != 0 ||grade.length() != 0 ||
                                    college.length() != 0 || major.length() != 0 || hometown.length() != 0 ) {
                                AVObject textObject = AVObject.createWithoutData("PerInfo", objectId);
                                if (name.length() != 0) textObject.put("name", name);
                                if (schoolnumber.length() != 0) textObject.put("schoolnumber",schoolnumber);
                                if (sex.length() != 0) textObject.put("sex", sex);
                                if (grade.length() != 0) textObject.put("grade", grade);
                                if (college.length() != 0)
                                    textObject.put("college", college);
                                if (major.length() != 0)
                                    textObject.put("major", major);
                                if (hometown.length() != 0) textObject.put("hometown",hometown);
                                textObject.put("username",username);
                                textObject.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(AVException e) {
                                        if (e == null) {
                                            LogUtil.log.d("saved", "success!");
                                            //Toast.makeText(PerInfoEditor.this, "e==NULL", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                                Toast.makeText(gerenziliaoEditor.this, "提交成功", Toast.LENGTH_SHORT).show();
                                finish();
                                //}
                            } else
                                Toast.makeText(gerenziliaoEditor.this, "您尚未修改任何内容", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(gerenziliaoEditor.this, "未知错误", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void back_perinfo(View v){finish();}
}
