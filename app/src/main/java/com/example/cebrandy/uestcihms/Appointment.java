package com.example.cebrandy.uestcihms;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.GetCallback;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Appointment extends AppCompatActivity {
    Button btn;
    String ObjectId;
    Date date = null;
    TextView dateDisplay;
    int mYear, mMonth, mDay;
    final int DATE_DIALOG = 1;
    long Years = 365 * 1000 * 60 * 60 * 24L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appointment);

        btn = (Button) findViewById(R.id.dateChoose);
        dateDisplay = (TextView) findViewById(R.id.dateDisplay);
        ObjectId =getIntent().getStringExtra("ObjectId");
        final EditText Name=(EditText)findViewById(R.id.appointName);
        final EditText Num=(EditText)findViewById(R.id.appointNum);
        final EditText Tel=(EditText)findViewById(R.id.appointTel);
        final Button Appointment =(Button)findViewById(R.id.doAppointment);



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG);
            }
        });

        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);
        Appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=Name.getText().toString();
                final String num=Num.getText().toString();
                final String tel=Tel.getText().toString();
                dateDisplay = (TextView) findViewById(R.id.dateDisplay);
                if(name.isEmpty())
                {
                    Toast.makeText(Appointment.this,"请输入姓名",Toast.LENGTH_SHORT).show();
                }
                if(num.isEmpty())
                {
                    Toast.makeText(Appointment.this,"请输入学号",Toast.LENGTH_SHORT).show();
                }
                if(tel.isEmpty())
                {
                    Toast.makeText(Appointment.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }
                else if(dateDisplay.getText().toString().isEmpty())
                {
                    Toast.makeText(Appointment.this,"请输入预约时间",Toast.LENGTH_SHORT).show();
                }
                else {
                    AVQuery<AVObject> avQuery = new AVQuery<>("Doctor");
                    avQuery.getInBackground(ObjectId, new GetCallback<AVObject>() {
                        @Override
                        public void done(AVObject avObject, AVException e) {
                            AVObject Reminder = new AVObject("AppointmentRemind");// 构建对象

                            Reminder.put("UserName", AVUser.getCurrentUser().getUsername());
                            Reminder.put("TreatDep", avObject.getString("depart"));
                            Reminder.put("Name", name);
                            Reminder.put("Num", num);
                            Reminder.put("stu_tel", tel);
                            Reminder.put("DoctName", avObject.getString("name"));
                            Reminder.put("reservedDoctor", avObject.getString("name"));
                            Reminder.put("doc_tel", avObject.getString("tel"));
                            Reminder.put("ARTime", date);
                            Reminder.saveInBackground();// 保存到服务端
                            Toast.makeText(Appointment.this,"预约成功",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Appointment.this,MainActivity.class));
                        }
                    });
                }
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                DatePickerDialog dialog = new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
                DatePicker dp = dialog.getDatePicker();
                dp.setMinDate(new Date().getTime());
                dp.setMaxDate(new Date().getTime()+Years);
//                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
                return dialog;
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        dateDisplay.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    public void back(View v){finish();}
}
