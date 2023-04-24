package com.example.todo_lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TodoAdapter extends ArrayAdapter<TodoItem> {
    int resource;
    private ArrayList<TodoItem> todoLists = new ArrayList<>();

    public TodoAdapter(@NonNull Context context, int resource, ArrayList<TodoItem> todoItemList) {
        super(context, resource, todoItemList);
        this.resource = resource;
        this.todoLists = todoItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View contextView, @NonNull ViewGroup parent) {
        View view = contextView;
        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
            view = layoutInflater.inflate(this.resource, null);
        }
        TodoItem todoItem = getItem(position);
        if (todoItem != null){

        }
        return view;
    }

}
