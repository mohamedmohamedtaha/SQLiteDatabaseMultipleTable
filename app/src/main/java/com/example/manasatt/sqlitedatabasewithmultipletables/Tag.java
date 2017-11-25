package com.example.manasatt.sqlitedatabasewithmultipletables;

import java.util.Date;

/**
 * Created by MANASATT on 19/05/17.
 */

public class Tag {
    int id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    String tag_name;
    //constructors
    public Tag(){

    }
    public Tag(String tag_name){
        this.tag_name = tag_name;
    }
    public Tag(int id,String tag_name){
        this.id= id;
        this.tag_name=tag_name;
    }
}
