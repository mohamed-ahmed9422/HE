package com.example.thanya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.splash);
        setContentView(R.layout.activity_main);
        int secondsDelayed = 2;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Splash.this , Home.class);
                startActivity(intent);
            }
        }, secondsDelayed * 1000);
    }
}
