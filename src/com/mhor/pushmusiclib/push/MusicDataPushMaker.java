package com.mhor.pushmusiclib.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import com.mhor.pushmusiclib.model.*;

import java.util.Date;
import java.util.UUID;

public class MusicDataPushMaker extends PushMaker
{
    public static String API_ROUTE = "";

    protected PushMusicLibData pushMusicLibData = new PushMusicLibData();

    public MusicDataPushMaker(Context applicationContext)
    {
        super(applicationContext);
    }

    public void getMusicLib()
    {
        this.setDeviceIntoDataPush();
        this.setMusicLibContentIntoDataPush();
    }

    private void setMusicLibContentIntoDataPush()
    {
        String[] STAR = {"*"};
        Uri allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        Cursor cursor = this.context.getContentResolver().query(
                allsongsuri,
                STAR,
                selection,
                null,
                null
        );

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Album album = this.extractAlbum(cursor);
                    Artist artist = this.extractArtist(cursor);
                    Style style = this.extractStyle(cursor);
                    Track track = this.extractTrack(cursor);

                    this.putTrackDataOnPushData(album, artist, style, track);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
    }

    private void putTrackDataOnPushData(Album album, Artist artist, Style style, Track track)
    {
        if (!this.pushMusicLibData.albumExist(album)) {
            this.pushMusicLibData.getAlbums().add(album);
        }
        track.setTrackStyle(style);
        track.setArtist(artist);
        this.pushMusicLibData.putTrack(album, track);
    }

    private void setDeviceIntoDataPush()
    {
        this.pushMusicLibData.setPushId(UUID.randomUUID() + "");
        Date date = new Date();
        this.pushMusicLibData.setDatePush(date.toString());

        SharedPreferences settings = this.context.getSharedPreferences(PushMusicLibData.PREFS_PUSH_MUSIC_LIB, 0);
        String token = settings.getString(PushMusicLibData.PREFS_PUSH_MUSIC_LIB_TOKEN, null);
        String deviceId = Settings.Secure.getString(this.context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String deviceName = Build.MANUFACTURER + " " + Build.MODEL;
        this.pushMusicLibData.setDevice(new Device(token, deviceId, deviceName));
    }

    protected Style extractStyle(Cursor cursor)
    {
        return null;
    }

    protected Artist extractArtist(Cursor cursor)
    {
        int id = cursor.getInt(
                cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)
        );

        String name = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
        );

        return new Artist(id, name);
    }

    protected Track extractTrack(Cursor cursor)
    {
        int id = cursor.getInt(
                cursor.getColumnIndex(MediaStore.Audio.Media._ID)
        );

        String name = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)
        );

        int trackNumber = cursor.getInt(
                cursor.getColumnIndex(MediaStore.Audio.Media.TRACK)
        );

        String duration = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.DURATION)
        );

        String fullpath = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
        );

        String year = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.YEAR)
        );

        String dateAdd = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.DATE_ADDED)
        );

        String dateModified = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.DATE_MODIFIED)
        );

        return new Track(
                id,
                name,
                fullpath,
                year,
                duration,
                trackNumber,
                dateAdd,
                dateModified
        );
    }

    protected Album extractAlbum(Cursor cursor)
    {
        String name = cursor.getString(
                cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)
        );

        int id = cursor.getInt(
                cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
        );

        return new Album(id, name);
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    public boolean isValid()
    {
        return true;
    }

    public PushMusicLibData getPushData()
    {
        return this.pushMusicLibData;
    }
}
