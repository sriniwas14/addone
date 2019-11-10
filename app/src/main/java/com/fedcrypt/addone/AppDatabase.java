package com.fedcrypt.addone;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.fedcrypt.addone.dao.ReminderDao;
import com.fedcrypt.addone.tables.Reminder;

@Database(entities = {Reminder.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase instance;
    public abstract ReminderDao reminderDao();

    public static AppDatabase getDatabaseInstance(Context ctx){
        if(instance==null){
            instance = Room.databaseBuilder(ctx.getApplicationContext(), AppDatabase.class, "db_addone").allowMainThreadQueries().build();
            Log.e(ctx.getString(R.string.log_tag), "Creating New DB Instance!");
        } else {
            Log.e(ctx.getString(R.string.log_tag) , "Returned Existing Instance");
        }
        return instance;
    }

    public static void destroyInstance() {
        instance = null;
    }
}
