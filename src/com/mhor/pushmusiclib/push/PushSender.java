package com.mhor.pushmusiclib.push;

import com.mhor.pushmusiclib.model.PushMusicLibData;

public class PushSender
{
    protected PushMusicLibData pushMusicLib;

    public PushSender(PushMusicLibData pushData)
    {
        this.pushMusicLib = pushData;
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    public PushResponse send()
    {
        this.pushDataByChunk();
        return null;

    }

    /**
     * @return
     * @TODO Not Implemented
     */
    protected int pushDataByChunk()
    {
        return this.pushData();
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    protected int pushData()
    {
        return 0;
    }
}
