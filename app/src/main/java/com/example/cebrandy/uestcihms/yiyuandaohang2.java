package com.example.cebrandy.uestcihms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.net.URISyntaxException;

public class yiyuandaohang2 extends AppCompatActivity {


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

    }






    /**
     * 确认起终点名称BY高德
     */
    public  void setUpGaodeAppByName(){
        try {
            EditText mylocal=(EditText) findViewById(R.id.mylocal);
            String weizhi=mylocal.getText().toString();
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname"+"&sname="+weizhi+"&dname="+"电子科技大学清水河校区校医院"+"&dev=0&m=0&t=1");
            if(isInstallByread("com.autonavi.minimap")){

                Toast.makeText(yiyuandaohang2.this,"高德地图客户端已经安装",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else {
                Toast.makeText(yiyuandaohang2.this,"高德地图客户端没有安装",Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 我的位置BY高德
     */
    public void setUpGaodeAppByMine(){
        try {
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname&sname=我的位置&dlat="+LATITUDE_B+"&dlon="+LONGTITUDE_B+"&dname="+"电子科技大学清水河校区校医院"+"&dev=0&m=0&t=1");
            if(isInstallByread("com.autonavi.minimap")){

                Toast.makeText(yiyuandaohang2.this,"高德地图客户端已经安装",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else {
                Toast.makeText(yiyuandaohang2.this,"高德地图客户端没有安装",Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }



    /**
     * 通过起终点名字使用百度地图
     */
    public void setUpBaiduAPPByName(){
        try {
            EditText mylocal=(EditText) findViewById(R.id.mylocal);
            String weizhi=mylocal.getText().toString();
            Intent intent = Intent.getIntent("intent://map/direction?origin="+weizhi+"&destination=电子科技大学清水河校区校医院&mode=driving&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            if(isInstallByread("com.baidu.BaiduMap")){

                Toast.makeText(yiyuandaohang2.this,"百度地图客户端已经安装",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else {
                Toast.makeText(yiyuandaohang2.this,"百度地图客户端没有安装",Toast.LENGTH_SHORT).show();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 我的位置到终点通过百度地图
     */
    public void setUpBaiduAPPByMine(){
        try {
            Intent intent = Intent.getIntent("intent://map/direction?origin=我的位置&destination=电子科技大学清水河校区校医院&mode=driving&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
            if(isInstallByread("com.baidu.BaiduMap")){

                Toast.makeText(yiyuandaohang2.this,"百度地图客户端已经安装",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else {
                Toast.makeText(yiyuandaohang2.this,"百度地图客户端没有安装",Toast.LENGTH_SHORT).show();
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
