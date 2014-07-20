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

    public int getId()
    {
        return id;
    }
}
