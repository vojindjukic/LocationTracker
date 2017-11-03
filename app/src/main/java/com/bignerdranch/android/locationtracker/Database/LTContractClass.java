package com.bignerdranch.android.locationtracker.Database;

import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import static com.bignerdranch.android.locationtracker.Database.LTContractClass.Tracks.CREATE_TABLE;

/**
 * Created by vojin.djukic on 11/2/2017.
 */

public class LTContractClass {
    public static final String DATABASE_NAME = "LTDatabase.db";
    public static final int DATABASE_VERSION = 1;


    public static class Tracks implements BaseColumns {
        public static final String TABLE_NAME = "Tracks";
        public static final String NAME_COLUMN = "name";
        public static final String DESCRIPTION_COLUMN = "description";

        public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
                + _ID + " integer primary key autoincrement, "
                + NAME_COLUMN + " string not null,"
                + DESCRIPTION_COLUMN + " string not null"
                + " );";

        public static void onCreate(SQLiteDatabase database) {
            database.execSQL(CREATE_TABLE);
        }
    }

    public static class Locations implements BaseColumns {
        public static final String TABLE_NAME = "Locations";
        public static final String MY_TRACK_ID_COLUMN = "track_id";
        public static final String LATITUDE_COLUMN = "latitude";
        public static final String LONGITUDE_COLUMN = "longitude";
        public static final String ALTITUDE_COLUMN = "altitude";
        public static final String SPEED_COLUMN = "speed";

        public static final String CREATE_TABLE = "create table " + TABLE_NAME + " ("
                + _ID + " integer primary key autoincrement, "
                + MY_TRACK_ID_COLUMN + " string not null, "
                + LATITUDE_COLUMN + " string not null, "
                + LONGITUDE_COLUMN + " string not null, "
                + ALTITUDE_COLUMN + " string not null, "
                + SPEED_COLUMN + " string not null"
                + " );";

        public static void onCreate(SQLiteDatabase database) {
            database.execSQL(CREATE_TABLE);
        }
    }
}
