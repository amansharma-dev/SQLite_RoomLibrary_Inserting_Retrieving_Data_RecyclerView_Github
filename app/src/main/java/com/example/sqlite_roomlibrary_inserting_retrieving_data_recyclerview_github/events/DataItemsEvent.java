package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.events;

import com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model.DataItem;

import java.util.List;

public class DataItemsEvent {

    private List<DataItem> dataItems;

    public DataItemsEvent(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }

    public List<DataItem> getDataItems() {
        return dataItems;
    }

    public void setDataItems(List<DataItem> dataItems) {
        this.dataItems = dataItems;
    }
}
