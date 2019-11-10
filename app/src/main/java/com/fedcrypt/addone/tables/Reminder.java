package com.fedcrypt.addone.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reminder {
    @PrimaryKey
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueAt() {
        return dueAt;
    }

    public void setDueAt(String dueAt) {
        this.dueAt = dueAt;
    }

    public String getPriority() {
        return priority;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "details")
    public String details;

    @ColumnInfo(name = "due_at")
    public String dueAt;

    @ColumnInfo(name = "priority")
    public String priority;

    @ColumnInfo(name = "completed")
    public Boolean completed;
}
