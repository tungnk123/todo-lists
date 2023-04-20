package com.example.todo_lists;

import android.widget.DatePicker;

import java.io.Serializable;

public class TodoItem implements Serializable {
    public String title;
    public String description;
    public String date;
    public boolean isDone = false;
    public TodoItem(){
        title = "title";
        description = "description";
        date = "1/1/2000";
        isDone = false;
    }

    public TodoItem (String title, String desc, String date, boolean isDone){
        this.title = title;
        this.description = desc;
        this.date = date;
        this.isDone = isDone;
    }
}
