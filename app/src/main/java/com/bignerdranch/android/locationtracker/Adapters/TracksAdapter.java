package com.bignerdranch.android.locationtracker.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bignerdranch.android.locationtracker.Database.LocationHelper;
import com.bignerdranch.android.locationtracker.Model.Track;
import com.bignerdranch.android.locationtracker.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by vojin.djukic on 11/2/2017.
 */

public class TracksAdapter extends ArrayAdapter<Track> {

    public TracksAdapter(Context context) {
        super(context, R.layout.tracks_array, new LocationHelper(context).getAllTracks());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        Track track = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(getContext());
        convertView = inflater.inflate(R.layout.tracks_array, parent, false);

        TextView nameView = (TextView) convertView.findViewById(R.id.textViewName);
        TextView descriptionView = (TextView) convertView.findViewById(R.id.textViewDescription);

        nameView.setText(track.getName());
        descriptionView.setText(track.getDescription());

        return convertView;
    }

    public String getName(View view){

        String name = ((TextView)view.findViewById(R.id.textViewName)).getText().toString();
        return name;
    }

}