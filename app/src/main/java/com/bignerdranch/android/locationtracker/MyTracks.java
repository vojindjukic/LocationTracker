package com.bignerdranch.android.locationtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MyTracks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tracks);
    }

    public void click_on_settings_button(View view) {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public void click_on_new_track_button (View view){
        Intent newTrackIntent = new Intent(this, NewTrackActivity.class);
        startActivity(newTrackIntent);
    }
}
