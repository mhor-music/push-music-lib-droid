package com.mhor.pushmusiclib.model;

import java.util.ArrayList;

public class Album
{
    protected ArrayList<Track> tracks;
    protected Artist albumArtist;

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
}
