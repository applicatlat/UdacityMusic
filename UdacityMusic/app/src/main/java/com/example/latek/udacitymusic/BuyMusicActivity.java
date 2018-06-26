package com.example.latek.udacitymusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BuyMusicActivity extends AppCompatActivity {
    ImageView myList;
    ImageView buyMusic;
    ImageView myAccount;
    ImageView home;
    ListView lister;
    Intent myListActivity;
    Intent myAccountActivity;
    Intent homeActivity;
    ScrollView mainScroll;
    Boolean ownOrNot;
    Integer def;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageview references
        myList = findViewById(R.id.playListMain);
        buyMusic = findViewById(R.id.buyMusicMain);
        buyMusic.setImageResource(R.drawable.buymusicpressed);
        myAccount = findViewById(R.id.myAccountMain);
        home = findViewById(R.id.mainHomeMain);
        home.setImageResource(R.drawable.home);
        //clears main activity scrollview content
        mainScroll = findViewById(R.id.scrollMain);
        mainScroll.setVisibility(View.GONE);
        SharedPreferences theSavedValue = getSharedPreferences("my_prefs", 0);
        final Integer moneyAccount = theSavedValue.getInt("LIQUID",0);
        //On demand changes to list. set on click listener to a button
        //opens play list activity
        myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListActivity = new Intent(BuyMusicActivity.this, PlayListActivity.class);
                startActivity(myListActivity);
            }
        });

        //opens wishList activity
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAccountActivity = new Intent(BuyMusicActivity.this, MyAccountActivity.class);
                startActivity(myAccountActivity);
            }
        });
        //opens main activity
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity = new Intent(BuyMusicActivity.this, MainActivity.class);
                startActivity(homeActivity);
            }
        });
        lister = findViewById(R.id.list);
        lister.setVisibility(View.VISIBLE);

        ArrayList<AdapterOrganizer> words = new ArrayList<AdapterOrganizer>();
        //words.add("one"); new code after <string> to <word> otherwise it gives errors
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","DJ Kerem",getString(R.string.song)+"","Writing",getString(R.string.album)+"","Is",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Akumba",getString(R.string.song)+"","Really",getString(R.string.album)+"","Funny",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Kody",getString(R.string.song)+"","But",getString(R.string.album)+"","Hurts",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Zangif",getString(R.string.song)+"","My Brain",getString(R.string.album)+"","Sometimes",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Whatever",getString(R.string.song)+"","However",getString(R.string.album)+"","Feeling",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Dr. Kink",getString(R.string.song)+"","That Knowing",getString(R.string.album)+"","Coding",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","DJ Kerem",getString(R.string.song)+"","Is More Than",getString(R.string.album)+"","Satisfying",getString(R.string.price)+"",200, ownOrNot));
        words.add(new AdapterOrganizer(getString(R.string.artist)+"","Hope",getString(R.string.song)+"","You Like It",getString(R.string.album)+"","Farewell!",getString(R.string.price)+"",200, ownOrNot));
        //parent view
        AdapterMachine adapter = new AdapterMachine(this, words);
        lister.setAdapter(adapter);
    }
    }

