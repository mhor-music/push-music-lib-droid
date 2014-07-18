package com.mhor.pushmusiclib.push;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.mhor.pushmusiclib.model.*;

public class PushMaker
{
    protected PushMusicLib pushMusicLib = new PushMusicLib();

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

                } while (cursor.moveToNext());
            }
            cursor.close();
        }
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

    /**
     * @TODO Not Fully Implemented
     */
    protected Artist extractArtist(Cursor cursor)
    {
        String artist_name = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)
        );

        int artist_id = cursor.getInt(
            cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST_ID)
        );
        return null;
    }

    /**
     * @TODO Not Fully Implemented
     */
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
        return null;
    }

    /**
     * @TODO Not Fully Implemented
     */
    protected Album extractAlbum(Cursor cursor)
    {
        String album_name = cursor.getString(
            cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM)
        );

        int album_id = cursor.getInt(
            cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
        );
        return null;
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
    public PushMusicLib getPushData()
    {
        return null;
    }
}
