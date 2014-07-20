package com.mhor.pushmusiclib.model;

import java.util.ArrayList;

public class PushMusicLibData
{
    protected String pushId;

    protected String datePush;

    protected Device device = null;

    protected ArrayList<Album> albums = new ArrayList<Album>();

    protected boolean first = false;

    protected boolean last = false;

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

    public boolean albumExist(Album album)
    {
        for (Album ab : this.getAlbums()) {
            if (ab.getId() == album.getId()) {
                return true;
            }
        }
        return false;
    }

    public void putTrack(Album album, Track track)
    {
        this.getAlbum(album).getTracks().add(track);
    }

    private Album getAlbum(Album album)
    {
        for (Album ab : this.getAlbums()) {
            if (ab.getId() == album.getId()) {
                return ab;
            }
        }
        return null;
    }

    public void setLast(boolean last)
    {
        this.last = last;
    }

    public Device getDevice()
    {
        return device;
    }

    public void setDevice(Device device)
    {
        this.device = device;
    }

    public void setFirst(boolean first)
    {
        this.first = first;
    }
}
