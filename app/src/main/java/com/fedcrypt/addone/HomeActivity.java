package com.fedcrypt.addone;

import android.os.Bundle;

import com.fedcrypt.addone.adapters.ReminderItemAdapter;
import com.fedcrypt.addone.elements.ReminderItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
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
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        upcomingItemsView.setLayoutManager(layoutManager);
        upcomingItemsView.setItemAnimator(new DefaultItemAnimator());

        upcomingItemsView.setAdapter(reminderItemAdapter);

        addTempData();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void addTempData(){
        ReminderItem reminder = new ReminderItem("1", "Kill the cat", "Be Careful of the claws", "15:23", "Urgent");
        upcomingItems.add(reminder);

        reminder = new ReminderItem("1", "Download Android Studio", "But you already have it installed", "17:23", "Urgent");
        upcomingItems.add(reminder);
    }

}
