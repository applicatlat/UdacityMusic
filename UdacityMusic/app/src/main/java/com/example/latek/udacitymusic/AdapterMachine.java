package com.example.latek.udacitymusic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterMachine extends ArrayAdapter<AdapterOrganizer> {
    public AdapterMachine(Context context, ArrayList<AdapterOrganizer> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final AdapterOrganizer currentWord = getItem(position);
        TextView artist = (TextView) listItemView.findViewById(R.id.artist_view);
        artist.setText(currentWord.getArtistName());
        TextView song = (TextView) listItemView.findViewById(R.id.song_view);
        song.setText(currentWord.getSongName());
        TextView album = (TextView) listItemView.findViewById(R.id.album_view);
        album.setText(currentWord.getAlbumName());
        TextView price = (TextView) listItemView.findViewById(R.id.price_view);
        price.setText(String.valueOf(currentWord.getMoney()));
        TextView artistFixed = (TextView) listItemView.findViewById(R.id.artist_fixed);
        artistFixed.setText(currentWord.getArtistNameFixed());
        TextView songFixed = (TextView) listItemView.findViewById(R.id.song_fixed);
        songFixed.setText(currentWord.getSongNameFixed());
        TextView albumFixed = (TextView) listItemView.findViewById(R.id.album_fixed);
        albumFixed.setText(currentWord.getAlbumNameFixed());
        TextView priceFixed = (TextView) listItemView.findViewById(R.id.price_fixed);
        priceFixed.setText(currentWord.getPriceFixed());
                //got the ideafrom here https://jmsliu.com/2444/click-button-in-listview-and-get-item-position.html
        Button buySong = (Button) listItemView.findViewById(R.id.buttonAdd);
        buySong.setTag(position);
        buySong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //I got the dialog builder from an old app of mine which was also a udacity project. here the link:https://github.com/applicatlat/KnowledgeIsPower/blob/master/KnowledgeisPower/app/src/main/java/com/example/android/knowledgeispower/MainActivity.java
                AlertDialog.Builder yesNo = new AlertDialog.Builder(getContext());
                yesNo.setMessage("Do you want to buy " + currentWord.getArtistName() + "'s " + currentWord.getSongName() + " song?").setCancelable(false)
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            //I figured it out by myself
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int position = getPosition(currentWord);
                                Intent sender = new Intent(getContext(),PlayListActivity.class);
                                Bundle intSender = new Bundle();
                                    intSender.putInt("position1", position);

                                sender.putExtras(intSender);
                                sender.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                getContext().startActivity(sender);
                            }
                        });

                AlertDialog alert = yesNo.create();
                alert.setTitle("Warning!");   // CHECK THIS LATER
                alert.show();
            }
        });
        return listItemView;
    }
}