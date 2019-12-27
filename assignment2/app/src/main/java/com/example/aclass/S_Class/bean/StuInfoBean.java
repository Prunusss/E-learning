package com.example.aclass.S_Class.bean;

public class StuInfoBean {
    public String sno;
    public String sname;
    public String classno;

    public StuInfoBean(String sno,String sname,String classno){
        this.sno=sno;
        this.sname=sname;
        this.classno=classno;
    }
    public String getSno(){
        return this.sno;

    }
    public String getSname(){
        return this.sname;

    }
    public String getClassno(){
        return this.classno;
    }
}
