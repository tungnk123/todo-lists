package com.example.todo_lists;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class TodoAdapter extends ArrayAdapter<TodoItem> {
    public Context context;
    int resource;

    public TodoAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
