package com.mhor.pushmusiclib.push;

import com.mhor.pushmusiclib.model.Album;
import com.mhor.pushmusiclib.model.PushMusicLibData;

public class MusicDataPushSender
{
    protected PushMusicLibData pushMusicLibData;

    protected PushMusicLibData currentMusicLibData;

    protected PushResponse pushResponse;

    static final protected int ALBUM_BY_CHUNK = 5;

    static final protected String API_URL = "http://push-music-lib.mhor.com/api/1.0/push";

    public MusicDataPushSender(PushMusicLibData pushData)
    {
        this.pushMusicLibData = pushData;
    }

    public PushResponse send()
    {
        this.pushDataByChunk();
        return this.pushResponse;
    }

    protected void pushDataByChunk()
    {
        int i = 0;
        this.instantiateNewCurrentMusicLib();
        this.currentMusicLibData.setFirst(true);

        for (Album album : this.pushMusicLibData.getAlbums()) {

            this.currentMusicLibData.getAlbums().add(album);
            if (i == MusicDataPushSender.ALBUM_BY_CHUNK) {
                this.pushData();
                this.instantiateNewCurrentMusicLib();
                i = 0;
            }
            i++;
        }
        this.currentMusicLibData.setLast(true);
        this.pushData();
    }

    protected void instantiateNewCurrentMusicLib()
    {
        this.currentMusicLibData = new PushMusicLibData();
        this.currentMusicLibData.setPushId(this.pushMusicLibData.getPushId());
        this.currentMusicLibData.setDevice(this.pushMusicLibData.getDevice());
        this.currentMusicLibData.setDatePush(this.pushMusicLibData.getDatePush());
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    protected void pushData()
    {
    }
}
