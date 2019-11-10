package com.fedcrypt.addone.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.fedcrypt.addone.tables.Reminder;

import java.util.List;

@Dao
public interface ReminderDao {
    @Query("SELECT * FROM reminder")
    List<Reminder> getAll();
//
//    @Query("SELECT * FROM reminder WHERE uid IN (:userIds)")
//    List<Reminder> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Reminder... reminders);

    @Delete
    void delete(Reminder reminder);
}
