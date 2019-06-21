package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.sample.SampleDataProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList = SampleDataProvider.dataItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataItemAdapter dataItemAdapter = new DataItemAdapter(this,dataItemList);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dataItemAdapter);
    }
}
