package com.bignerdranch.android.locationtracker.Database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

import com.bignerdranch.android.locationtracker.Model.Location;
import com.bignerdranch.android.locationtracker.Model.Track;

import java.util.ArrayList;
import java.util.Iterator;

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

    //saves Track and returns Track ID
    public long saveTrack(Track track) {
        ContentValues values = new ContentValues();
        values.put(LTContractClass.Tracks.NAME_COLUMN, track.getName());
        values.put(LTContractClass.Tracks.DESCRIPTION_COLUMN, track.getDescription());
        SQLiteDatabase db = getWritableDatabase();
        long trackId = db.insert(LTContractClass.Tracks.TABLE_NAME, null, values);
        return trackId;
    }

    public ArrayList<Track> getAllTracks(){
        Cursor cursor = getReadableDatabase().query(LTContractClass.Tracks.TABLE_NAME, null, null, null, null, null, null, null);
        ArrayList<Track> tracks = new ArrayList<>();
        while(cursor.moveToNext()){
            Track track = new Track(cursor.getString(1), cursor.getString(2));
            tracks.add(track);
        }
        cursor.close();
        return tracks;
    }

    public void saveLocations(long trackId, ArrayList<Location> locationsList){
        for (int i = 0; i < locationsList.size(); i++){
            Location location = locationsList.get(i);
            ContentValues values = new ContentValues();
            values.put(LTContractClass.Locations.MY_TRACK_ID_COLUMN, trackId);
            values.put(LTContractClass.Locations.LATITUDE_COLUMN, location.getLatitude());
            values.put(LTContractClass.Locations.LONGITUDE_COLUMN, location.getLongitude());
            values.put(LTContractClass.Locations.ALTITUDE_COLUMN, location.getAltitude());
            values.put(LTContractClass.Locations.SPEED_COLUMN, location.getSpeed());
            SQLiteDatabase db = getWritableDatabase();
            db.insert(LTContractClass.Locations.TABLE_NAME, null, values);
            db.close();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
