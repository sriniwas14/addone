package com.fedcrypt.addone;

import android.content.Intent;
import android.os.Bundle;

import com.fedcrypt.addone.adapters.ReminderItemAdapter;
import com.fedcrypt.addone.elements.ReminderItem;
import com.fedcrypt.addone.tables.Reminder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private AppDatabase appDatabase;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView upcomingItemsView;
    private List<ReminderItem> upcomingItems = new ArrayList<>();
    private ReminderItemAdapter reminderItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        upcomingItemsView = findViewById(R.id.upcomingItemsView);

        reminderItemAdapter = new ReminderItemAdapter(upcomingItems);
        layoutManager = new LinearLayoutManager(this);
        upcomingItemsView.setLayoutManager(layoutManager);
        upcomingItemsView.setItemAnimator(new DefaultItemAnimator());

        upcomingItemsView.setAdapter(reminderItemAdapter);

        appDatabase = AppDatabase.getDatabaseInstance(this);

        getReminders();
        reloadRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, AddReminderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        upcomingItems = new ArrayList<>();
        getReminders();
        reloadRecyclerView();
    }

    private void reloadRecyclerView(){
        upcomingItemsView.swapAdapter(reminderItemAdapter, false);
        reminderItemAdapter = new ReminderItemAdapter(upcomingItems);
        upcomingItemsView.setAdapter(reminderItemAdapter);
        upcomingItemsView.invalidate();
    }

    private void getReminders() {
        List<Reminder> items = appDatabase.reminderDao().getAll();

        for(Reminder reminder: items){
            ReminderItem reminderItem = new ReminderItem(String.valueOf(reminder.getId()), reminder.getTitle(), reminder.getDetails(), reminder.getDueAt(), reminder.getPriority(), reminder.getCompleted());
            upcomingItems.add(reminderItem);
        };
    }

}
