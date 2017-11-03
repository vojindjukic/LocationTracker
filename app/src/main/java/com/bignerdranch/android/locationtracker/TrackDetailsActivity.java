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

public class TrackDetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);

        TextView myView = (TextView)findViewById(R.id.textViewTitle);

        LocationHelper LocationHelper = new LocationHelper(this);
        SQLiteDatabase db = LocationHelper.getReadableDatabase();
        Cursor cursor = db.query("Tracks", new String[]{"name"}, null, null, null, null, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
//            myView.setText(String.valueOf(cursor.getCount()));
            myView.setText(cursor.getString(0));
            cursor.moveToNext();
        }

    }

    public void onDoneButton(View view) {
        finish();
    }

    public void onAddLocation (View view) {

        Intent intent = new Intent (this, AddLocationActivity.class);
        startActivity(intent);
    }
}
