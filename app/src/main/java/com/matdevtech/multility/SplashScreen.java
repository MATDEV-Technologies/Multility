package com.matdevtech.multility;

// Imports
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

// Main class
public class SplashScreen extends AppCompatActivity {

    // Global variables within the class (private is accessible only within the class) (suggestion: make local in onCreate())
    @SuppressWarnings("FieldCanBeLocal")
    private final static int SPLASH_TIME_OUT = 1000; // Original: 3500 (this was changed to be faster just like how it is on iOS)

    // Activity init
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Handle and manage splash screen display time
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}