package com.mhor.pushmusiclib;

import android.app.Activity;
import android.os.Bundle;
import com.mhor.pushmusiclib.push.PushMaker;
import com.mhor.pushmusiclib.push.PushResponse;
import com.mhor.pushmusiclib.push.PushSender;

public class MainActivity extends Activity
{
    protected PushMaker pushMaker = new PushMaker();

    protected PushSender pushSender;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.pushMaker.getMusicLib(this.getContentResolver());

        if (this.pushMaker.isValid()) {
            this.pushSender = new PushSender(this.pushMaker.getPushData());
            PushResponse response = this.pushSender.send();
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
