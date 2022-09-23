package com.example.traveldiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity
{
    // timer for setting splash screen
    Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.welcome);
        videoView.setVideoURI(uri);
        videoView.start();

        // setting splash screen
        timer = new Timer();
        timer.schedule(new TimerTask(){
                @Override
                public void run()
                {
                    startActivity(new Intent(MainActivity.this, LoginUser.class));
                }
            },5000);

        finish();
    }
}