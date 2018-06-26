package com.example.latek.udacitymusic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MyAccountActivity extends AppCompatActivity {
    ImageView myList;
    ImageView buyMusic;
    ImageView myAccount;
    ImageView home;
    Intent myListActivity;
    Intent buyMusicActivity;
    Intent homeActivity;
    int songsOwned = 0;
    public int capital;
    TextView accountInfo;
    TextView creditAvailable;
    TextView accountNamePlace;
    TextView songAmount;
    ScrollView scrollMain;
    ScrollView scrollMain2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageview references
        myList = findViewById(R.id.playListMain);
        buyMusic = findViewById(R.id.buyMusicMain);
        myAccount = findViewById(R.id.myAccountMain);
        myAccount.setImageResource(R.drawable.accountpressed);
        home = findViewById(R.id.mainHomeMain);
        home.setImageResource(R.drawable.home);
        //textviews
        accountNamePlace = findViewById(R.id.userName);
        accountInfo = findViewById(R.id.accountTypeChange);
        creditAvailable = findViewById(R.id.creditAmount);
        songAmount = findViewById(R.id.songAmount);
        songAmount.setText(String.valueOf(songsOwned));
        //retrieving account values
        SharedPreferences theSavedValue = getSharedPreferences("my_prefs", 0);
        String userNameSaved = theSavedValue.getString("ID", "");
        String accountValueSaved = theSavedValue.getString("VALUE","");
        Integer moneyAccount = theSavedValue.getInt("LIQUID",0);
        accountNamePlace.setText(userNameSaved);
        accountInfo.setText(accountValueSaved);
        creditAvailable.setText(String.valueOf(moneyAccount));
        capital = moneyAccount;
        //opens play list activity
        myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListActivity = new Intent(MyAccountActivity.this, PlayListActivity.class);
                startActivity(myListActivity);
            }
        });
        //opens buyMUsic activity
        buyMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyMusicActivity = new Intent(MyAccountActivity.this, BuyMusicActivity.class);
                startActivity(buyMusicActivity);
            }
        });

        //opens main activity
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeActivity = new Intent(MyAccountActivity.this, MainActivity.class);
                startActivity(homeActivity);
            }
        });
        //set text programatically within scrollview
        scrollMain = findViewById(R.id.scrollMain);
        scrollMain.setVisibility(View.GONE);
        scrollMain2 = findViewById(R.id.scrollAccount);
        scrollMain2.setVisibility(View.VISIBLE);
    }

}
