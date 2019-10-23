package com.example.cebrandy.uestcihms;



        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;


public class lianxikefuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lianxikefu);


    }
    public void  button_service(View v){
        startActivity(new Intent(lianxikefuActivity.this,dialog.class));
    }
}