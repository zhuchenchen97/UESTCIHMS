package com.example.cebrandy.uestcihms;

/**
 * Created by cebrandy on 2017/11/20.
 */

public class BaoGao {

    private String stu_name;
    private String stu_num;
    private String doc_name;
    private String symptom;
    private String objectId;
    private String diagnosis;
    private String time;

    public BaoGao(String stu_name, String stu_num,String doc_name,String symptom, String diagnosis, String time, String objectId)
    {
        this.stu_name=stu_name;
        this.stu_num=stu_num;
        this.doc_name=doc_name;
        this.symptom=symptom;
        this.objectId=objectId;
        this.diagnosis=diagnosis;
        this.time=time;

    }



    public String getstu_name(){return "患者姓名:"+stu_name;}
    public String getstu_num(){
        return "患者学号:"+stu_num;
    }
    public String getdoc_name(){
        return "医生姓名:"+doc_name;
    }
    public String getsymptom(){
        return "患者症状:"+symptom;
    }
    public String getdiagnosis(){
        return "诊断:"+diagnosis;
    }
    public String gettime()
    {
        return "就诊时间:"+time;
    }

    public String getObjectId(){return objectId;}

}
