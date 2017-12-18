package com.bignerdranch.android.locationtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.MyLocation;
import com.bignerdranch.android.locationtracker.Model.Track;
import com.bignerdranch.android.locationtracker.R;

import java.util.ArrayList;


/**
 * Created by vojin.djukic on 11/10/2017.
 */

public class LocationsAdapter extends ArrayAdapter<MyLocation> {

    public LocationsAdapter(Context context, ArrayList<MyLocation> locationsList) {
        super(context, R.layout.locations_array, locationsList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        MyLocation location = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.locations_array, parent, false);

        TextView indexView = (TextView) convertView.findViewById(R.id.textViewIndex);
        TextView latitudeView = (TextView) convertView.findViewById(R.id.textViewLatitude);
        TextView longitudeView = (TextView) convertView.findViewById(R.id.textViewLongitude);
        TextView altitudeView = (TextView) convertView.findViewById(R.id.textViewAltitude);

        indexView.setText(Integer.toString(position + 1));
        latitudeView.setText("LAT " + location.getLatitude());
        longitudeView.setText("LONG " + location.getLongitude());
        altitudeView.setText("ALT " + location.getAltitude());

        return convertView;
    }

}
