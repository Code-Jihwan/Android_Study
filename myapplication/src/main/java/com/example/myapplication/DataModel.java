package com.example.myapplication;

public class DataModel {
    private String title;
    private String contents;
    private String time;
    private String writer;

    public DataModel(String title, String contents, String time, String writer) {
        this.title = title;
        this.contents = contents;
        this.time = time;
        this.writer = writer;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}

    public String getContents() {
        return contents;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
}
