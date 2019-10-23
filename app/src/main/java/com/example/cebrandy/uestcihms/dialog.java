package com.example.cebrandy.uestcihms;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class dialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflaterDl = LayoutInflater.from(this);
        LinearLayout layout = (LinearLayout)inflaterDl.inflate(R.layout.dialog_layout, null );


        //对话框
        final Dialog dialog = new AlertDialog.Builder(dialog.this).create();
        dialog.show();
        dialog.getWindow().setContentView(layout);


        //取消按钮
        Button btnCancel = (Button) layout.findViewById(R.id.tel_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //确定按钮
        Button btnOK = (Button) layout.findViewById(R.id.tel_connect);
        btnOK.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentcall = new Intent(Intent.ACTION_DIAL);
                intentcall.setData(Uri.parse("tel:15608057069"));
                startActivity(intentcall);
            }
        });



    }
}