package com.bignerdranch.android.locationtracker;

import android.Manifest;
import android.app.Activity;
import android.content.IntentSender;
import android.location.Location;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.bignerdranch.android.locationtracker.Adapters.LocationsAdapter;
import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.MyLocation;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.Objects;

public class TrackDetailsActivity extends AppCompatActivity {

    private ArrayList<MyLocation> locationsList;
    private long trackId;
    private ListView listView;
    private LocationsAdapter adapter;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_details);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        locationsList = new ArrayList<MyLocation>();
        adapter = new LocationsAdapter(this, locationsList);
        listView = (ListView) findViewById(R.id.mylocations_list);
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        Bundle extras = getIntent().getExtras();
        String caller = extras.getString("caller");

        switch (caller) {

            case "NewTrackActivity":
                String trackName = extras.getString("trackName");
                trackId = extras.getLong("trackId");
                TextView myView = (TextView) findViewById(R.id.textViewTitle);
                myView.setText(trackName + " Track Details");
                break;

            case "MyTracks":
                trackName = extras.getString("trackName");
                myView = (TextView) findViewById(R.id.textViewTitle);
                myView.setText(trackName + " Track Details");
                long id = Long.valueOf(extras.getInt("position")) + 1; //+1 because indexes in database start from 1 not 0
                LocationHelper helper = new LocationHelper(this);
                locationsList = helper.getLocation(id);
                adapter = new LocationsAdapter(this, locationsList);
                listView = (ListView) findViewById(R.id.mylocations_list);
                listView.setAdapter(adapter);

                //disable Add button
                Button addButton = (Button) findViewById(R.id.buttonAddLocation);
                addButton.setEnabled(false);
                addButton.setBackgroundColor(Color.GRAY);
                break;
        }

        adapter.notifyDataSetChanged();
        if (adapter.getCount() > 0) {
            findViewById(R.id.textViewEmptyList).setVisibility(View.GONE);
        }
    }

    public void onDoneButton(View view) {

        Bundle extras = getIntent().getExtras();
        String caller = extras.getString("caller");
        if (Objects.equals(caller, "MyTracks")) {
            finish();
        } else {
            new LocationHelper(this).saveLocations(trackId, locationsList);
            finish();
        }
    }

    public void onAddLocation(View view) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        Task task = mFusedLocationClient.getLastLocation();
                task.addOnSuccessListener(new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if (location != null) {
                            MyLocation loc = new MyLocation(location.getLatitude(), location.getLongitude(), location.getAltitude(), location.getSpeed());
                            locationsList.add(loc);;
                            adapter.notifyDataSetChanged();
                            if (adapter.getCount() > 0) {
                                findViewById(R.id.textViewEmptyList).setVisibility(View.GONE);
                            }
                        }
                    }
                });

//                task.addOnFailureListener(this, new OnFailureListener() {
//                });

//        Intent intent = new Intent (this, AddLocationActivity.class);
//        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Bundle extras = data.getExtras();
                locationsList.add((MyLocation)extras.getSerializable("location"));
            }
        }
    }
}
