package com.bignerdranch.android.locationtracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.Location;

import java.util.ArrayList;

public class TrackDetailsActivity extends AppCompatActivity {

    private static ArrayList<Location> locationsList;
    private long trackId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);

        locationsList = new ArrayList<Location>();

//        LocationHelper LocationHelper = new LocationHelper(this);
//        SQLiteDatabase db = LocationHelper.getReadableDatabase();
//        Cursor cursor = db.query("Tracks", new String[]{"name"}, null, null, null, null, null);
//        cursor.moveToFirst();

//        while (!cursor.isAfterLast()) {
//            myView.setText(cursor.getString(0));
//            cursor.moveToNext();
//        }

    }

    @Override
    public void onResume(){
        super.onResume();

        Bundle extras = getIntent().getExtras();
        String caller =  extras.getString("caller");
        switch (caller){

            case "NewTrackActivity":
                String trackName = extras.getString("trackName");
                trackId = extras.getLong("trackId");
                TextView myView = (TextView) findViewById(R.id.textViewTitle);
                myView.setText(trackName + " Details");
                break;
            case "AddLocationActivity":
                locationsList.add((Location)extras.getSerializable("location"));
                break;
        }
    }

    public void onDoneButton(View view) {

        new LocationHelper(this).saveLocations(trackId, locationsList);

        finish();
    }

    public void onAddLocation (View view) {

        Intent intent = new Intent (this, AddLocationActivity.class);
        startActivity(intent);
    }
}
