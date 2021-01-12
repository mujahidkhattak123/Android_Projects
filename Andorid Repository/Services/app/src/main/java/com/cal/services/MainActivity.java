package com.cal.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    String msg="Android";

    Button buttonStart, buttonStop,buttonNext;




    /** Called when the activity is first created. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStart = findViewById(R.id.btn_start_service);
        buttonStop = findViewById(R.id.btn_stop_service);




        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startService(new Intent(getApplicationContext(), mServices.class));
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stopService(new Intent(getApplicationContext(), mServices.class));
            }
        });

    }
//public void startService(View view){
//
//        startService(new Intent(getBaseContext(),Services.class));
//
//}
//
//    // Method to stop the service
//public void stopService(View view){
//        stopService(new Intent(getBaseContext(),Services.class));
//
//
//}

}