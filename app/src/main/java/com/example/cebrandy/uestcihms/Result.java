package com.example.cebrandy.uestcihms;

/**
 * Created by cebrandy on 2017/11/25.
 */

public class Result {
    private String name;
    private String gailv;
    private String zhengzhuang;
    private String objectId;

    public Result(String name, String gailv, String zhengzhuang)
    {
        this.name=name;
        this.gailv=gailv;
        this.zhengzhuang=zhengzhuang;

    }

    public String getName(){
        return name;
    }

    public String getGailv()
    {
        return "患病概率："+gailv;
    }

    public String getZhengzhuang()
    {
        return "常见症状："+zhengzhuang;
    }

    public String getObjectId()
    {
        return objectId;
    }
}
