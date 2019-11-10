package com.fedcrypt.addone.elements;

public class ReminderItem {
    private String id, title, details, dueAt, priority;
    private Boolean completed;

    public ReminderItem(String id, String title, String details, String dueAt, String priority, Boolean completed) {
        this.id = id;
        this.title = title;
        this.details = details;
        this.dueAt = dueAt;
        this.priority = priority;
        this.completed = completed;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public String getDueAt() {
        return dueAt;
    }

    public String getPriority() {
        return priority;
    }
}
