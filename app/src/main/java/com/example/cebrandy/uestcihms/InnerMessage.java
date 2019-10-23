package com.example.cebrandy.uestcihms;

/**
 * Created by 13982 on 2017/7/9.
 */

public class InnerMessage {
    private String title;
    private String content;
    private String time;
    private String objectId;

    public InnerMessage(String title, String content, String time, String objectId)
    {
        this.content=content;
        this.time=time;
        this.title=title;
        this.objectId=objectId;
    }

    public String getTitle(){
        return title;
    }

    public String getContent()
    {
        return content;
    }

    public String getTime()
    {
        return time;
    }

    public String getObjectId()
    {
        return objectId;
    }
}
