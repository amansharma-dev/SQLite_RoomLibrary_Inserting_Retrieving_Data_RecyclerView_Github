package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;

@Database(entities = {DataItem.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract DataItemDao dataItemDao();

    public static AppDatabase getInstance(Context context) {

        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"myapp-database")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public static void destroyInstance(){
        instance = null;
    }
}
