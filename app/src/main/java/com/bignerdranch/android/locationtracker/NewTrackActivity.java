package com.bignerdranch.android.locationtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

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

        Track track = new Track(((EditText) findViewById(R.id.editTextName)).getText().toString(), ((EditText) findViewById(R.id.editTextName)).getText().toString());
        new LocationHelper(this).saveTrack(track);

        Intent intent = new Intent(this, TrackDetailsActivity.class);
        startActivity(intent);
    }
}
