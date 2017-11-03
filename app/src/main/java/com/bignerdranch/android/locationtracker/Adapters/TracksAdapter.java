package com.bignerdranch.android.locationtracker.Adapters;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.bignerdranch.android.locationtracker.R;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

/**
 * Created by vojin.djukic on 11/2/2017.
 */

public class TracksAdapter extends ArrayAdapter <String> {

    public static ArrayList<String> trackNames = new ArrayList<String>(){{
        add("A");
        add("B");
        add("C");
    }};

    public TracksAdapter(Context context) {
        super(context, R.layout.tracks_array, R.id.textViewName, trackNames);
    }

}
