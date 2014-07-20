package com.mhor.pushmusiclib.model;

import java.util.ArrayList;

public class Album
{
    protected ArrayList<Track> tracks = new ArrayList<Track>();
    protected Artist albumArtist;
    protected String name;
    protected int id;

    public Album(int album_id, String album_name)
    {
        this.id = album_id;
        this.name = album_name;
    }

    public ArrayList<Track> getTracks()
    {
        return tracks;
    }

    public void setTracks(ArrayList<Track> tracks)
    {
        this.tracks = tracks;
    }

    public Artist getAlbumArtist()
    {
        return albumArtist;
    }

    public void setAlbumArtist(Artist albumArtist)
    {
        this.albumArtist = albumArtist;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
