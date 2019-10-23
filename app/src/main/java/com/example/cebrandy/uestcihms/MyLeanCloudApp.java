package com.example.cebrandy.uestcihms;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;

public class MyLeanCloudApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        AVOSCloud.initialize(this,"iLznGS3TEc69xsCDkVxLevXg-gzGzoHsz","2UrjHQdPfWwe3UOOdm9fBrVG");
        AVOSCloud.setDebugLogEnabled(true);

    }
}
