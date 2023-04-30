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
    EditText editTextDesc;
    DatePicker datePicker;
    CheckBox checkBoxIsDone;

    TextView tvTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_new);

        btnSave = (Button) findViewById(R.id.button_save);
        editTextTitle = (EditText) findViewById(R.id.editText_title);
//        editTextDesc = (EditText)findViewById(R.id.editText_title);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        checkBoxIsDone = (CheckBox) findViewById(R.id.checkBox1);

        // Intent from main
        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String month = intent.getStringExtra("month");
            String year = intent.getStringExtra("year");
            String day = intent.getStringExtra("day");
            String title = intent.getStringExtra("title");
            boolean isDone = intent.getBooleanExtra("isDone", false);

            if (!title.isEmpty()) {
                editTextTitle.setText(title);
            }
            checkBoxIsDone.setChecked(isDone);


            int year_int = Integer.parseInt(year);
            int day_int = Integer.parseInt(day);
            int month_int = Integer.parseInt(month);

            datePicker.updateDate(year_int, month_int - 1, day_int);

        }

        //

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentBack = new Intent(getBaseContext(), MainActivity.class);
                intentBack.putExtra("isDone", checkBoxIsDone.isChecked());
                String date = datePicker.getDayOfMonth() + "/" + (datePicker.getMonth() + 1) + "/" + datePicker.getYear();
                intentBack.putExtra("date", date);
//                intentBack.putExtra("desc",editTextDesc.getText().toString());
                intentBack.putExtra("title", editTextTitle.getText().toString());
                setResult(RESULT_OK, intentBack);
                finish();
            }
        });

    }
}