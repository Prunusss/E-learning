package com.example.aclass.S_Class;

public class Message {
    public String time;
    public String neirong;
    public String name;
    public Message(String time,String neirong,String name){
        this.time=time;
        this.neirong=neirong;
        this.name=name;
    }
    public String getTime(){
        return this.time;
    }
    public String getNeirong(){
        return this.neirong;
    }
    public String getName(){
        return this.name;
    }
}
