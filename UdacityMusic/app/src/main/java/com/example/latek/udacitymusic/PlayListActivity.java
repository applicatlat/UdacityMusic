package com.example.latek.udacitymusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class PlayListActivity extends AppCompatActivity {
    ImageView myList;
    ImageView buyMusic;
    ImageView myAccount;
    ImageView home;
    ListView lister;
    Intent buyMusicActivity;
    Intent myAccountActivity;
    Intent homeActivity;
    ScrollView mainScroll;
    String artist;
    Boolean ownOrNot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences theSavedValue = getSharedPreferences("my_prefs", 0);
        Integer moneyAccount = theSavedValue.getInt("LIQUID",0);
        //imageview references
        myList = findViewById(R.id.playListMain);
        myList.setImageResource(R.drawable.playlistpressed);
        buyMusic = findViewById(R.id.buyMusicMain);
        myAccount = findViewById(R.id.myAccountMain);
        home = findViewById(R.id.mainHomeMain);

        //clears main activity scrollview content
        mainScroll = findViewById(R.id.scrollMain);
        mainScroll.setVisibility(View.GONE);
        //opens buyMUsic activity
        buyMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyMusicActivity = new Intent(PlayListActivity.this, BuyMusicActivity.class);
                startActivity(buyMusicActivity);
            }
        });
        //opens wishList activity
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAccountActivity = new Intent(PlayListActivity.this, MyAccountActivity.class);
                startActivity(myAccountActivity);
            }
        });
        //opens main activity
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity = new Intent(PlayListActivity.this, MainActivity.class);
                startActivity(homeActivity);
            }
        });

        lister = findViewById(R.id.list);
        lister.setVisibility(View.VISIBLE);
        Bundle positionReciever = getIntent().getExtras();
        final int position = positionReciever.getInt("position1");
        ArrayList<AdapterOrganizer> words = new ArrayList<AdapterOrganizer>();
        //words.add("one"); new code after <string> to <word> otherwise it gives errors
        if (position==0) {
            words.add(new AdapterOrganizer(getString(R.string.artist) + "", "DJ Kerem", getString(R.string.song) + "", "Writing", getString(R.string.album) + "", "Is", null, null, null));
             } else {
            words.add(new AdapterOrganizer("","","","","","","",null,null));
        }
        if (position==1) {
            words.add(new AdapterOrganizer(getString(R.string.artist) + "", "DJ Kerema", getString(R.string.song) + "", "Writing", getString(R.string.album) + "", "Is", null, null, null));
        } else {
            words.add(new AdapterOrganizer("","","","","","","",null,null));
        }
        if (position==2) {
            words.add(new AdapterOrganizer(getString(R.string.artist) + "", "DJ Keremb", getString(R.string.song) + "", "Writing", getString(R.string.album) + "", "Is", null, null, null));
        } else {
            words.add(new AdapterOrganizer("","","","","","","",null,null));
        }
        if (position==3) {
            words.add(new AdapterOrganizer(getString(R.string.artist) + "", "DJ Keremc", getString(R.string.song) + "", "Writing", getString(R.string.album) + "", "Is", null, null, null));
        } else {
            words.add(new AdapterOrganizer("","","","","","","",null,null));
        }
        //parent view
        AdapterMachine adapter = new AdapterMachine(this, words);
        lister.setAdapter(adapter);

    }
}
