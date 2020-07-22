package com.matdevtech.multility;

// Imports
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/* > Task :app:compileDebugJavaWithJavac
Note: /Users/michaeldavid/Desktop/Coding/GITHUB/Multility/app/src/main/java/com/matdevtech/multility/SplashScreen.java uses or overrides a deprecated API.
Note: Recompile with -Xlint:deprecation for details.
*/

// Main class
public class SplashScreen extends AppCompatActivity {

    // Class const(s)
    private final static int SPLASH_TIME_OUT = 2000; // Original: 3500 (this was changed to be faster just like how it is on iOS)

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