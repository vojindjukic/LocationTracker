package com.bignerdranch.android.locationtracker.Model;

/**
 * Created by vojin.djukic on 11/3/2017.
 */

public class Track {

    private String name;
    private String description;

    public Track (String name, String description){

        this.setName(name);
        this.setDescription(description);
    }

    public String getName (){
        return this.name;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription (String description){
        this.description = description;
    }

}
