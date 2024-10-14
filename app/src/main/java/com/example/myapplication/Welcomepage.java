package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class Welcomepage extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        // Delay of 2 seconds before navigating to MainActivity (Login Screen)
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcomepage.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close WelcomeActivity to prevent returning to it
            }
        }, SPLASH_DELAY);
    }
}
