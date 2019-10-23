package com.example.cebrandy.uestcihms;

/**
 * Created by 13982 on 2017/7/9.
 */

public class ReminderMessage {

    private String treatDep;
    private String name;
    private String doctName;
    private String ARTime;
    private String objectId;
    private String Num;
    private String stu_tel;
    private String doc_tel;
    public ReminderMessage(String treatDep, String name,String Num,String stu_tel, String doctName, String doc_tel,String ARTime, String objectId)
    {
        this.ARTime=ARTime;
        this.doctName=doctName;
        this.name=name;
        this.treatDep=treatDep;
        this.objectId=objectId;
        this.doc_tel=doc_tel;
        this.Num=Num;
        this.stu_tel=stu_tel;
    }



    public String getTreatDep(){
        return "预约科室:"+treatDep;
    }
    public String getName(){
        return "患者姓名:"+name;
    }
    public String getNum(){
        return "患者学号:"+Num;
    }
    public String getstu_tel(){
        return "患者手机号:"+stu_tel;
    }
    public String getDoctName(){
        return "医生姓名:"+doctName;
    }
    public String getdoc_tel(){
        return "医生手机号:"+doc_tel;
    }
    public String getARTime()
    {
        return "预约时间:"+ARTime;
    }

    public String getObjectId(){return objectId;}
}
