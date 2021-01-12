package com.cal.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.security.Provider;

public class mServices extends Service {

    MediaPlayer myPlayer;

    @Override
    public void onCreate() {

    }



    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        myPlayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        myPlayer.setLooping(true); // Set looping
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        myPlayer.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();

        myPlayer.stop();
    }


}
