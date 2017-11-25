package com.example.manasatt.sqlitedatabasewithmultipletables;

/**
 * Created by MANASATT on 19/05/17.
 */

public class Todo {
    int id;
    String note;
    int status;
    String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    //constructors
    public Todo(){

    }
    public Todo(String note,int status){
        this.note =note;
        this.status=status;

    }
    public Todo(int id,String note,int status){
        this.id = id;
        this.note = note;
        this.status = status;
            }



























}
