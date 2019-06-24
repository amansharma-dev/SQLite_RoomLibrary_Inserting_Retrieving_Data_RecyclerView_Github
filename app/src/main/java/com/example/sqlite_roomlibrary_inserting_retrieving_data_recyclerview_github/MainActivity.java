package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.database.AppDatabase;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.events.DataItemsEvent;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.sample.SampleDataProvider;
import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.utils.JSONHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<DataItem> dataItemList;

    private AppDatabase appDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = AppDatabase.getInstance(this);

        executor.execute(new Runnable() {
            @Override
            public void run() {

                int itemCount = appDatabase.dataItemDao().countItems();
                if(itemCount == 0){
                    List<DataItem> dataItemList = JSONHelper.importFromResource(MainActivity.this);
                    appDatabase.dataItemDao().insertAll(dataItemList);
                    Log.i("MainActivtiy"," data inserted");
                }else{
//                    Toast.makeText(getApplicationContext(), "Data already exist", Toast.LENGTH_LONG).show();
                    Log.i("MainActivity","Data Already Exist");
                }
            }
        });


        executor.execute(new Runnable() {
            @Override
            public void run() {

                dataItemList = appDatabase.dataItemDao().getAll();
                EventBus.getDefault().post(new DataItemsEvent(dataItemList));
            }
        });


        EventBus.getDefault().register(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dataItemsEventHandler(DataItemsEvent event){

        dataItemList = event.getDataItems();

        DataItemAdapter dataItemAdapter = new DataItemAdapter(this,dataItemList);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(dataItemAdapter);
    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
