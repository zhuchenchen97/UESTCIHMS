package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.net.URISyntaxException;
import static android.R.attr.mode;
import static android.R.attr.scheme;
/**
 * Created by cebrandy on 2017/11/27.
 */

public class yiyuandaohang extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "yiyuandaohang";

    //--------------以下都是高德坐标系的坐标-------------------//
    private static final double LATITUDE_A = 28.1903;  //起点纬度
    private static final double LONGTITUDE_A = 113.031738;  //起点经度

    private static final double LATITUDE_B = 28.187519;  //终点纬度
    private static final double LONGTITUDE_B = 113.029713;  //终点经度



    //----------------以下都是百度坐标系的坐标------------------//
    private static final double LATITUDE_QIDIAN = 28.196744;  //起点纬度
    private static final double LONGTITUDE_QIDIAN = 113.037904;  //起点经度

    private static final double LATITUDE_ZHONGDIAN = 28.193159;  //终点纬度
    private static final double LONGTITUDE_ZHONGDIAN = 113.036427;  //终点经度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yiyuandaohang);

        this.findViewById(R.id.bt2).setOnClickListener(this);
        this.findViewById(R.id.bt3).setOnClickListener(this);

        this.findViewById(R.id.bt5).setOnClickListener(this);
        this.findViewById(R.id.bt6).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.bt2:

                setUpGaodeAppByName();

                break;

            case R.id.bt3:

                setUpGaodeAppByMine();

                break;




            case R.id.bt5:

                setUpBaiduAPPByName();

                break;

            case R.id.bt6:

                setUpBaiduAPPByMine();

                break;


        }
    }





    /**
     * 确认起终点名称BY高德
     */
    void setUpGaodeAppByName(){
        try {
            EditText mylocal=(EditText) findViewById(R.id.mylocal);
            String weizhi=mylocal.getText().toString();
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname"+"&sname="+weizhi+"&dname="+"电子科技大学清水河校区校医院"+"&dev=0&m=0&t=1");
            if(isInstallByread("com.autonavi.minimap")){
                startActivity(intent);
            }else {
                Toast.makeText(yiyuandaohang.this, "请先安装高德客户端", Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 我的位置BY高德
     */
    void setUpGaodeAppByMine(){
        try {
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname&sname=我的位置&dlat="+"&dname="+"电子科技大学清水河校区校医院"+"&dev=0&m=0&t=1");
            if(isInstallByread("com.autonavi.minimap")){
                startActivity(intent);
                Log.e(TAG, "高德地图客户端已经安装") ;
            }else {
                Toast.makeText(yiyuandaohang.this, "请先安装高德客户端", Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }




    /**
     * 通过起终点名字使用百度地图
     */
    void setUpBaiduAPPByName(){
        try {
            EditText mylocal=(EditText) findViewById(R.id.mylocal);
            String weizhi=mylocal.getText().toString();
            Intent intent = Intent.getIntent("intent://map/direction?origin="+weizhi+"&destination=电子科技大学清水河校区校医院&mode=driving&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            if(isInstallByread("com.baidu.BaiduMap")){
                startActivity(intent);
                Log.e(TAG, "百度地图客户端已经安装") ;
            }else {
                Toast.makeText(yiyuandaohang.this, "请先安装百度客户端", Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 我的位置到终点通过百度地图
     */
    void setUpBaiduAPPByMine(){
        try {
            Intent intent = Intent.getIntent("intent://map/direction?origin=我的位置&destination=电子科技大学清水河校区校医院&mode=driving&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            if(isInstallByread("com.baidu.BaiduMap")){
                startActivity(intent);
                Log.e(TAG, "百度地图客户端已经安装") ;
            }else {
                Toast.makeText(yiyuandaohang.this, "请先安装百度客户端", Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }



    /**
     * 判断是否安装目标应用
     * @param packageName 目标应用安装后的包名
     * @return 是否已安装目标应用
     */
    private boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

}
