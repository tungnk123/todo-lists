package com.example.todo_lists;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMain;
    TodoItem todoItemNewOrEdited;
    List<TodoItem> list = new ArrayList<>();

    //launcher de chuyen thong tin tu activity nay sang activity khac
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult activityResult) {
                    if (activityResult.getResultCode() == Activity.RESULT_OK) {
                        Intent intentBackFromSecond = activityResult.getData();
                        String title = intentBackFromSecond.getStringExtra("title");
//                        String desc = intentBackFromSecond.getStringExtra("desc");
                        String date = "1/1/2003";
                        boolean isDone = intentBackFromSecond.getBooleanExtra("isDone", false);
                        todoItemNewOrEdited = new TodoItem(title, " ", date, isDone);

                        Toast.makeText(getApplicationContext(), todoItemNewOrEdited.title + date + isDone, Toast.LENGTH_LONG).show();
                        // add todoItem moi vao list va set adapter lai
                        list.add(todoItemNewOrEdited);
//                        list.add(new TodoItem(title, "descripton", date, true));
                        TodoAdapter todoAdapter = new TodoAdapter(getApplicationContext(), R.layout.todo_listview_item, list);

                        lvMain.setAdapter(todoAdapter);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMain = (ListView) findViewById(R.id.listViewMain);
        TodoItem todoItem = new TodoItem("titleee", "descripton", "1/1/2000", false);
        list.add(todoItem);

        TodoAdapter todoAdapter = new TodoAdapter(getApplicationContext(), R.layout.todo_listview_item, list);
        lvMain.setAdapter(todoAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_new) {
            launcher.launch(new Intent(MainActivity.this, EditNewActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }


}