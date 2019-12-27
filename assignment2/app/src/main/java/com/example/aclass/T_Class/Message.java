package com.example.aclass.T_Class;

import java.util.Random;

public class Message {
    public String time;
    public String neirong;
    public String name;
    public int index;

    public static final int START = 0;   //定义范围开始数字

    public static final int END = 4; //定义范围结束数字

    private String names[]={"爱学习的人","认真学习","好好学习","天天向上","正在努力中"};

    public Message(String time, String neirong){
        this.time=time;
        this.neirong=neirong;
        Random random = new Random();

        //产生随机数
        index = random.nextInt(END - START + 1) + START;
        this.name=names[index];
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
    public int getIndex() {
        return this.index;
    }
}
