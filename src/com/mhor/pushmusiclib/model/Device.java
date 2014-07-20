package com.mhor.pushmusiclib.model;

public class Device
{
    protected String deviceName;

    protected String deviceId;

    protected String token;

    public Device(String deviceName, String deviceId, String token)
    {
        this.deviceName = deviceName;
        this.deviceId = deviceId;
        this.token = token;
    }
}
