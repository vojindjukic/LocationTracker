package com.bignerdranch.android.locationtracker;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.bignerdranch.android.locationtracker.Adapters.TracksAdapter;
import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.Track;

public class NewTrackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_track);
    }

    public void onStartButton(View view){

        String trackName = ((EditText) findViewById(R.id.editTextName)).getText().toString();
        String trackDescription = ((EditText) findViewById(R.id.editTextDescription)).getText().toString();
        Track track = new Track(trackName, trackDescription);

        long trackId = new LocationHelper(this).saveTrack(track);
        Intent intent = new Intent(this, TrackDetailsActivity.class);
        intent.putExtra("trackId", trackId);
        intent.putExtra("trackName", trackName);
        intent.putExtra("caller", "NewTrackActivity");
        startActivity(intent);
    }
}
