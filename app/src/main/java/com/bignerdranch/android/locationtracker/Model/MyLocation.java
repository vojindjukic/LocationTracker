package com.bignerdranch.android.locationtracker.Model;

import android.location.Location;

import java.io.Serializable;

/**
 * Created by vojin.djukic on 11/9/2017.
 */

public class MyLocation implements Serializable {

    private double mLatitude;
    private double mLongitude;
    private double mAltitude;
    private double mSpeed;


    public MyLocation(double latitude, double longitude, double altitude, double speed){
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mAltitude = altitude;
        this.mSpeed = speed;
    }

    public double getLatitude(){return this.mLatitude;}

    public double getLongitude(){return this.mLongitude;}

    public double getAltitude(){return this.mAltitude;}

    public double getSpeed(){return this.mSpeed;}
}
