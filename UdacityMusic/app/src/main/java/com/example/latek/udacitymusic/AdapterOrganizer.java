package com.example.latek.udacitymusic;

import android.content.SharedPreferences;
import android.graphics.Paint;

public class AdapterOrganizer {
    //state
    private String artistName;
    private String songName;
    private String albumName;
    private String artistNameFixed;
    private String songNameFixed;
    private String albumNameFixed;
    private String priceFixed;
    private Integer money;
    private Boolean hasIt;
    //constructor
    public AdapterOrganizer(String artistsNameFixed, String artistsName, String songsNameFixed, String songsName, String albumsNameFixed, String albumsName, String pricesFixed, Integer moneys, Boolean has){
        artistNameFixed = artistsNameFixed;
        artistName = artistsName;
        songName = songsName;
        albumName = albumsName;
        money = moneys;
        songNameFixed = songsNameFixed;
        albumNameFixed = albumsNameFixed;
        priceFixed = pricesFixed;
        hasIt = has;
    }
    //methods
    public String getArtistNameFixed(){
        return artistNameFixed;
    }
    public String getArtistName(){
        return artistName;
    }
    public String getSongNameFixed() {
        return songNameFixed;
    }
    public String getSongName() {
        return songName;
    }
    public String getAlbumNameFixed(){
        return albumNameFixed;
    }
    public String getAlbumName(){
        return albumName;
    }
    public String getPriceFixed() {
        return priceFixed;
    }
    public Integer getMoney() {
        return money;
    }
    public Boolean getHas() {
        return hasIt;
    }

}

