package com.mhor.pushmusiclib.model;

import java.util.ArrayList;

public class PushMusicLib
{
    protected String pushId;

    protected String datePush;

    protected Device device;

    protected ArrayList<Album> albums;

    public String getPushId()
    {
        return pushId;
    }

    public void setPushId(String pushId)
    {
        this.pushId = pushId;
    }

    public String getDatePush()
    {
        return datePush;
    }

    public void setDatePush(String datePush)
    {
        this.datePush = datePush;
    }

    public ArrayList<Album> getAlbums()
    {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums)
    {
        this.albums = albums;
    }
}
