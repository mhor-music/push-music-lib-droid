package com.mhor.pushmusiclib.push;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.mhor.pushmusiclib.model.*;

public class PushMaker
{
    protected PushMusicLibData pushMusicLibData = new PushMusicLibData();

    public void getMusicLib(ContentResolver cr)
    {
        this.setDeviceIntoDataPush(cr);
        this.setMusicLibContentIntoDataPush(cr);
    }

    /**
     * @param cr
     * @TODO Not fully implemented
     */
    private void setMusicLibContentIntoDataPush(ContentResolver cr)
    {
        String[] STAR = {"*"};
        Uri allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String selection = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        Cursor cursor = cr.query(
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
    }

    /**
     * @TODO Not Implemented
     */
    private void setDeviceIntoDataPush(ContentResolver cr)
    {
    }

    protected Style extractStyle(Cursor cursor)
    {
        return null;
    }

    protected Artist extractArtist(Cursor cursor)
    {
        String artist_name = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
        );

        int artist_id = cursor.getInt(
            cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)
        );

        Artist artist = new Artist(artist_id, artist_name);
        return artist;
    }

    protected Track extractTrack(Cursor cursor)
    {
        String song_name = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
        );

        int song_id = cursor.getInt(
            cursor.getColumnIndex(MediaStore.Audio.Media._ID)
        );

        String fullpath = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.DATA)
        );

        Track track = new Track(song_id, song_name, fullpath);
        return track;
    }

    protected Album extractAlbum(Cursor cursor)
    {
        String album_name = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)
        );

        int album_id = cursor.getInt(
            cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
        );

        Album album = new Album(album_id, album_name);
        return album;
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    public boolean isValid()
    {
        return true;
    }

    /**
     * @return
     * @TODO Not Implemented
     */
    public PushMusicLibData getPushData()
    {
        return null;
    }
}
