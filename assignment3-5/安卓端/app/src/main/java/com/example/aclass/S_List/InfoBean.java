package com.example.aclass.S_List;

public class InfoBean {
    private String title;
    private String content;
    private boolean attribute;
    private String date;
    private String ddl;



    public InfoBean(String title, String content, boolean attribute, String date) {
        this.title = title;
        this.content = content;
        this.attribute = attribute;
        this.date = date;
//        this.ddl=ddl;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public boolean getAttribute() {
        return attribute;
    }

    public String getDate() {
        return date;
    }
//    public String getDdl() {
//        return ddl;
//    }
}
