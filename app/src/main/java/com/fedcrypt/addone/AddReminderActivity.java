package com.fedcrypt.addone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fedcrypt.addone.tables.Reminder;

import java.util.Random;

public class AddReminderActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private EditText titleInput, taskDetailsInput;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        appDatabase = AppDatabase.getDatabaseInstance(this);

        titleInput = findViewById(R.id.titleInput);
        taskDetailsInput = findViewById(R.id.taskDetailsInput);

        addButton = findViewById(R.id.addbutton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addTodoItem()){
                    Toast.makeText(AddReminderActivity.this, "Added Task", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(AddReminderActivity.this, "Could not add", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private Boolean addTodoItem(){
        Random random = new Random();
        Integer uniqueId = random.nextInt(100000 - 0 + 1);
        Reminder reminder = new Reminder();

        reminder.setId(uniqueId);
        reminder.setTitle(titleInput.getText().toString());
        reminder.setDetails(taskDetailsInput.getText().toString());
        reminder.setDueAt("3456789");
        reminder.setPriority("Urgent");
        reminder.setCompleted(false);

        appDatabase.reminderDao().insertAll(reminder);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
