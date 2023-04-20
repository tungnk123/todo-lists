package com.example.todo_lists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditNewActivity extends AppCompatActivity {

    Button btnSave;
    EditText editTextTitle;
    DatePicker datePicker;
    CheckBox checkBoxIsDone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_new);

        btnSave = (Button) findViewById(R.id.button_save);
        editTextTitle = (EditText) findViewById(R.id.editText_title);

        checkBoxIsDone = (CheckBox) findViewById(R.id.checkBox1);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getBaseContext(), MainActivity.class);
                intentBack.putExtra("isDone", checkBoxIsDone.isChecked());
                intentBack.putExtra("title",editTextTitle.getText().toString());
                setResult(RESULT_OK, intentBack);
                finish();
            }
        });

    }
}