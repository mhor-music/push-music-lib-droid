package com.mhor.pushmusiclib.model;

public class Artist
{
    private final int id;

    protected String name;

    public Artist(int artist_id, String artist_name)
    {
        this.id = artist_id;
        this.name = artist_name;
    }
}
