package com.mhor.pushmusiclib;

import android.app.Activity;
import android.os.Bundle;
import com.mhor.pushmusiclib.push.MusicDataPushMaker;
import com.mhor.pushmusiclib.push.MusicDataPushSender;
import com.mhor.pushmusiclib.push.PushResponse;

public class MainActivity extends Activity
{
    protected MusicDataPushMaker musicDataPushMaker;

    protected MusicDataPushSender musicDataPushSender;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.musicDataPushMaker = new MusicDataPushMaker(this.getApplicationContext());
        this.musicDataPushMaker.getMusicLib();

        if (this.musicDataPushMaker.isValid()) {
            this.musicDataPushSender = new MusicDataPushSender(this.musicDataPushMaker.getPushData());
            PushResponse response = this.musicDataPushSender.send();
            this.showPushResponse(response);
        }
    }

    /**
     * @param response
     * @TODO Not Implemented
     */
    private void showPushResponse(PushResponse response)
    {
    }
}
