package com.bignerdranch.android.locationtracker.Database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.bignerdranch.android.locationtracker.Model.Track;

/**
 * Created by vojin.djukic on 10/31/2017.
 */

public class LocationHelper extends SQLiteOpenHelper {


    public LocationHelper(Context context) {
        super(context, LTContractClass.DATABASE_NAME, null, LTContractClass.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        LTContractClass.Tracks.onCreate(db);
        LTContractClass.Locations.onCreate(db);
    }

    public void saveTrack(Track track) {
        ContentValues values = new ContentValues();
        values.put(LTContractClass.Tracks.NAME_COLUMN, track.getName());
        values.put(LTContractClass.Tracks.DESCRIPTION_COLUMN, track.getDescription());
        getWritableDatabase().insert(LTContractClass.Tracks.TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
