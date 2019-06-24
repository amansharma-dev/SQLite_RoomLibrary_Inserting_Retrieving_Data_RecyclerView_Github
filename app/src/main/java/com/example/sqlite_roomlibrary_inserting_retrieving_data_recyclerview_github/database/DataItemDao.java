package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;

import java.util.List;

@Dao
public interface DataItemDao {

    @Insert
    void insertAll(List<DataItem> dataItems);

    @Insert
    void insertAll(DataItem... dataItems);

    @Query("SELECT COUNT(*) from dataItem")
    int countItems();
}
