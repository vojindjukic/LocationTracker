package com.bignerdranch.android.locationtracker.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.Location;
import com.bignerdranch.android.locationtracker.R;


/**
 * Created by vojin.djukic on 11/10/2017.
 */

public class LocationsAdapter extends ArrayAdapter<Location> {

    public LocationsAdapter(Context context, ArrayAdapter<Location> locationsList) {
        super(context, R.layout.tracks_array, locationsList);
    }

}
