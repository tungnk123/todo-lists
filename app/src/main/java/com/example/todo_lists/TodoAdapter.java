package com.example.todo_lists;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class TodoAdapter extends ArrayAdapter<TodoItem> {
    int resource;
    private List<TodoItem> todoLists = new ArrayList<>();

    public TodoAdapter(@NonNull Context context, int resource, List<TodoItem> todoItemList) {
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
            // lay thong tin trong view ra
            TextView tvTitle = (TextView) view.findViewById(R.id.textView_title);
            TextView tvDesc = (TextView) view.findViewById(R.id.textView_description);
            TextView tvDate = (TextView) view.findViewById(R.id.textView_date);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.checkBox1);

            //gan gia tri
            if (tvTitle != null){
                tvTitle.setText("title");
            }
//            tvDesc.setText("description");
            if (tvDate != null){
                tvDate.setText("date");
            }
            if (checkBox != null){
                checkBox.setChecked(true);
            }
        }
        return view;
    }

}
