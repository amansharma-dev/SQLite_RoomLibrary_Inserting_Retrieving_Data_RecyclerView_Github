package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.events;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;

public class DataItemEvent {
    private DataItem dataItem;


    public DataItemEvent(DataItem dataItem) {
        this.dataItem = dataItem;
    }

    public DataItem getDataItem() {
        return dataItem;
    }

    public void setDataItem(DataItem dataItem) {
        this.dataItem = dataItem;
    }
}
