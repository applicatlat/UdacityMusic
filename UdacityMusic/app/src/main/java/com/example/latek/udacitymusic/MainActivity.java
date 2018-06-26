package com.example.latek.udacitymusic;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView myList;
ImageView buyMusic;
ImageView myAccount;
ImageView homeBlur;
ImageView accountVisible;
String accountName;
String accountValue;
int money;
ScrollView mainScroll;
Intent myListActivity;
Intent buyMusicActivity;
Intent myAccountActivity;
RadioGroup accountTypes;
RadioButton platinum;
RadioButton gold;
RadioButton silver;
RadioButton bronze;
EditText userName;
CheckBox approval;
Button signUp;
TextView accountTypeChoose;
TextView welcomeText;
TextView firstLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //imageview references
        myList = findViewById(R.id.playListMain);
        buyMusic = findViewById(R.id.buyMusicMain);
        myAccount = findViewById(R.id.myAccountMain);
        //definition of radiogroup edittext checkbox butotn
        mainScroll = findViewById(R.id.scrollMain);
        accountTypes = findViewById(R.id.accountRadioMain);
        userName = findViewById(R.id.userNameTyped);
        accountName = userName.getText().toString();
        approval = findViewById(R.id.verificationMain);
        approval.setVisibility(View.GONE);
        signUp = findViewById(R.id.signUp);
        signUp.setVisibility(View.GONE);
        platinum = findViewById(R.id.platinum);
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        bronze = findViewById(R.id.bronze);
        //if on MainActivity change the home image
        homeBlur = findViewById(R.id.mainHomeMain);
        homeBlur.setImageResource(R.drawable.homepressed);
        homeBlur.setVisibility(View.VISIBLE);
        //got the shared preferences from here to save data but developed it myself https://stackoverflow.com/questions/15466673/how-to-send-data-through-intent-in-android-without-opening-another-activity
        SharedPreferences theSavedValue = getSharedPreferences("my_prefs", 0);
        String userNameSaved = theSavedValue.getString("ID", "");
        String accountValueSaved = theSavedValue.getString("VALUE","");
        Integer moneyAccount = theSavedValue.getInt("LIQUID",0);
        //if no data is typed open first login screen
        if (!userNameSaved.isEmpty() && !accountValueSaved.isEmpty() && !moneyAccount.equals(0)){
            //setting the post account login screen
            accountTypes.setVisibility(View.GONE);
            signUp.setVisibility(View.GONE);
            approval.setVisibility(View.GONE);
            userName.setVisibility(View.GONE);
            accountTypeChoose = findViewById(R.id.accountTypeChoose);
            accountTypeChoose.setVisibility(View.GONE);
            welcomeText = findViewById(R.id.typeUser);
            String hello = getString(R.string.hello);
            String welcome= getString(R.string.welcomer);
            String sum = hello + " " + userNameSaved +"," + "\n" + " " + welcome;
            welcomeText.setText(sum);
            accountVisible = findViewById(R.id.accountVisible);
            accountVisible.setVisibility(View.VISIBLE);
        }
        else {
            myList.setVisibility(View.GONE);
            buyMusic.setVisibility(View.GONE);
            myAccount.setVisibility(View.GONE);
            firstLogin = findViewById(R.id.firstLogin);
            firstLogin.setVisibility(View.VISIBLE);
            firstLogin.setText(getString(R.string.firstLogin));
        }

        //radio group code
        accountTypes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                approval.setVisibility(View.VISIBLE);
                if (checkedId==R.id.platinum){
                    money = 1000;
                    accountValue = "Platinum";
                }
                if (checkedId==R.id.gold){
                    money=750;
                    accountValue = "Gold";
                }
                if (checkedId==R.id.silver){
                    money=500;
                    accountValue = "Silver";
                }
                if (checkedId==R.id.bronze){
                    money=250;
                    accountValue = "Bronze";
                }
            }
        });
        //approval code
        approval.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                signUp.setVisibility(View.VISIBLE);
                if (!isChecked){
                    signUp.setVisibility(View.GONE);
                }
            }
        });

        //signup code
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = findViewById(R.id.userNameTyped);
                accountName = userName.getText().toString();

                //Here define all your sharedpreferences code with key and value the reference is above
                SharedPreferences prefs = getSharedPreferences("my_prefs", MODE_PRIVATE);
                SharedPreferences.Editor edit = prefs.edit();
                edit.putString("ID", accountName );
                edit.putString("VALUE", accountValue );
                edit.putInt("LIQUID", money);
                edit.apply();
                edit.commit();
                Intent intent = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(intent);
            }
        });
        myList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListActivity = new Intent(MainActivity.this, PlayListActivity.class);
                startActivity(myListActivity);
            }
        });
        //opens buyMUsic activity
        buyMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyMusicActivity = new Intent(MainActivity.this, BuyMusicActivity.class);
                startActivity(buyMusicActivity);
            }
        });

        //opens wishList activity
        myAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAccountActivity = new Intent(MainActivity.this, MyAccountActivity.class);
                startActivity(myAccountActivity);
            }
        });
    }
}
