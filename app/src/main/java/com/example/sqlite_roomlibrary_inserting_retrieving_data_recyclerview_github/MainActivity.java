package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.database.AppDatabase;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.sample.SampleDataProvider;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.utils.JSONHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    private AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getInstance(this);

        int itemCount = appDatabase.dataItemDao().countItems();
        if(itemCount == 0){
            List<DataItem> dataItemList = JSONHelper.importFromResource(this);
            appDatabase.dataItemDao().insertAll(dataItemList);
        }else{
            Toast.makeText(getApplicationContext(), "Data alreay exist", Toast.LENGTH_SHORT).show();
        }

        DataItemAdapter dataItemAdapter = new DataItemAdapter(this,dataItemList);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dataItemAdapter);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
