package com.bignerdranch.android.locationtracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bignerdranch.android.locationtracker.Model.MyLocation;

public class AddLocationActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);
    }

    public void onAdd(View view){
        double latitude = Double.parseDouble(((EditText) findViewById(R.id.editTextLatitude)).getText().toString());
        double longitude = Double.parseDouble(((EditText) findViewById(R.id.editTextLongitude)).getText().toString());
        double altitude = Double.parseDouble(((EditText) findViewById(R.id.editTextAltitude)).getText().toString());
        double speed = Double.parseDouble(((EditText) findViewById(R.id.editTextSpeed)).getText().toString());

        MyLocation location = new MyLocation (latitude, longitude, altitude, speed);
        Intent returnIntent = new Intent(this, TrackDetailsActivity.class);
        returnIntent.putExtra("caller", "AddLocationActivity");
        returnIntent.putExtra("location", location);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}
