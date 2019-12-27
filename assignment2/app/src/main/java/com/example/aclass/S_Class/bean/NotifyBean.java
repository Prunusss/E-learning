package com.example.aclass.S_Class.bean;

public class NotifyBean {
    private String title;
    private String time;
    private  String type;
    public NotifyBean(String title, String time,String type) {
        this.title = title;
        this.time = time;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
