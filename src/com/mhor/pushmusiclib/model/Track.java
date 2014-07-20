package com.mhor.pushmusiclib.model;

public class Track
{
    protected String dateAdd;

    protected String dateModified;

    protected int trackNumber;

    protected int id;

    protected String year;

    protected String fullpath;

    protected String name;

    protected String duration;

    protected String number;

    protected String playedNumber;

    protected Style trackStyle;

    protected Artist artist;

    public Track(int id, String name, String fullpath, String year, String duration, int trackNumber, String dateAdd, String dateModified)
    {
        this.id = id;
        this.name = name;
        this.fullpath = fullpath;
        this.year = year;
        this.duration = duration;
        this.trackNumber = trackNumber;
        this.dateAdd = dateAdd;
        this.dateModified = dateModified;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getPlayedNumber()
    {
        return playedNumber;
    }

    public void setPlayedNumber(String playedNumber)
    {
        this.playedNumber = playedNumber;
    }

    public Artist getArtist()
    {
        return artist;
    }

    public void setArtist(Artist artist)
    {
        this.artist = artist;
    }

    public Style getTrackStyle()
    {
        return trackStyle;
    }

    public void setTrackStyle(Style trackStyle)
    {
        this.trackStyle = trackStyle;
    }
}
