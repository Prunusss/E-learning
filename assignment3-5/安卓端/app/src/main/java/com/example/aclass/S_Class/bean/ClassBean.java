package com.example.aclass.S_Class.bean;

public class ClassBean {
    private String className;
    private String didian;
    private String teacher;
    private String date;
    public ClassBean(String className,String didian,String teacher,String date){
        this.className=className;
        this.didian=didian;
        this.teacher=teacher;
        this.date=date;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDidian() {
        return didian;
    }

    public void setDidian(String didian) {
        this.didian = didian;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
