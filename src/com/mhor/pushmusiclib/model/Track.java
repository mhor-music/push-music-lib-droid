package com.mhor.pushmusiclib.model;

/**
 * Created by maxime on 18/07/14.
 */
public class Track
{
    protected String name;

    protected String duration;

    protected String number;

    protected String playedNumber;

    protected Style trackStyle;

    protected Artist artist;

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
