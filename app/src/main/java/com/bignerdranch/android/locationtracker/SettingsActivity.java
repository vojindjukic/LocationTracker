package com.bignerdranch.android.locationtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        Spinner spinner = (Spinner)findViewById(R.id.Cities_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.Cities_array, android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);

    }

    public void click_on_done_button(View view) {

        finish();
    }
}
