package com.fedcrypt.addone.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reminder {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "details")
    public String details;

    @ColumnInfo(name = "due_at")
    public String dueAt;

    @ColumnInfo(name = "priority")
    public String priority;
}
