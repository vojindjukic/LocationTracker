package com.bignerdranch.android.locationtracker;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.bignerdranch.android.locationtracker.Adapters.TracksAdapter;
import com.bignerdranch.android.locationtracker.Database.LocationHelper;

public class MyTracks extends AppCompatActivity {

    private ListView listView;
    private TracksAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tracks);

        listView = (ListView) findViewById(R.id.mytracks_list);
        adapter = new TracksAdapter(this);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }

    public void click_on_settings_button(View view) {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }

    public void click_on_new_track_button (View view){

//        SQLiteDatabase db = new LocationHelper(this).getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("name", "ime");
//        values.put("description", "opis");
//        db.insert("Tracks", null, values);

//        SQLiteDatabase db = openOrCreateDatabase("LocationDB", Context.MODE_PRIVATE, null);
//        db.execSQL("CREATE TABLE IF NOT EXISTS tracks(id INTEGER, name VARCHAR,description VARCHAR);");
//        db.execSQL("INSERT INTO tracks VALUES(1, 'ime', 'opis');");
       // SQLiteDatabase db = openOrCreateDatabase("LocationDB", Context.MODE_PRIVATE, null);

//        String sql = "INSERT INTO Tracks VALUES ('ime', 'opis');";
        //compile the statement and start a transaction
//        LocationHelper lHelper = new LocationHelper(this);
//        SQLiteDatabase db = lHelper.getWritableDatabase();
//        SQLiteStatement statement = db.compileStatement(sql);
//        db.beginTransaction();
//        statement.clearBindings();
//        statement.execute();
//        statement.close();
//        db.setTransactionSuccessful();
//        db.endTransaction();

        Intent newTrackIntent = new Intent(this, NewTrackActivity.class);
        startActivity(newTrackIntent);
    }
}
