package com.example.sqlite_roomlibrary_inserting_retrieving_data_recyclerview_github.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.content.ContentValues;
import android.support.annotation.NonNull;

import java.util.UUID;
@Entity
public class DataItem {

    @PrimaryKey
    @NonNull
    private String itemId;
    @ColumnInfo
    private String artistImage;
    @ColumnInfo
    private String songName;
    @ColumnInfo
    private String artistName;
    @ColumnInfo
    private String artistGenre;
    @ColumnInfo
    private double songPrice;

    public DataItem(){}

    @Ignore
    public DataItem(String itemId, String artistImage, String songName, String artistName, String artistGenre, double songPrice) {

        if(itemId == null){
            itemId = UUID.randomUUID().toString();
        }

        this.itemId = itemId;
        this.artistImage = artistImage;
        this.songName = songName;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
        this.songPrice = songPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getArtistImage() {
        return artistImage;
    }

    public void setArtistImage(String artistImage) {
        this.artistImage = artistImage;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }

    public double getSongPrice() {
        return songPrice;
    }

    public void setSongPrice(double songPrice) {
        this.songPrice = songPrice;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "itemId='" + itemId + '\'' +
                ", artistImage='" + artistImage + '\'' +
                ", songName='" + songName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", artistGenre='" + artistGenre + '\'' +
                ", songPrice=" + songPrice +
                '}';
    }
}
