package com.mhor.pushmusiclib.model;

public class Track
{
    protected String dateAdd;

    protected String dateModified;

    protected int id;

    protected String year;

    protected String fullpath;

    protected String name;

    protected String duration;

    protected int number;

    protected String playedNumber;

    protected Style trackStyle;

    protected Artist artist;

    public Track(int id, String name, String fullpath, String year, String duration, int number, String dateAdd, String dateModified)
    {
        this.id = id;
        this.name = name;
        this.fullpath = fullpath;
        this.year = year;
        this.duration = duration;
        this.number = number;
        this.dateAdd = dateAdd;
        this.dateModified = dateModified;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public void setTrackStyle(Style trackStyle)
    {
        this.trackStyle = trackStyle;
    }
}
