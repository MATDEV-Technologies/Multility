package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

// Main class
public class SettingsActivity extends AppCompatActivity {
    // Class vars
    @SuppressWarnings("FieldCanBeLocal")
    private Button button1, button2, button3;

    // Activity init
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Button init(s)
        // Grab IDs and listen for clicks/taps
        button1 = findViewById(R.id.terms_of_service_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTermsOfService();
            }
        });
        button2 = findViewById(R.id.privacy_policy_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPrivacyPolicy();
            }
        });
        button3 = findViewById(R.id.about_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    // Check if the back arrow is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            super.onBackPressed(); // Goto -> parent activity -> main
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void openTermsOfService() {
        // Create a new intent and launch it with the activity
        Intent intent1 = new Intent(this, TermsOfService.class);
        startActivity(intent1);
    }

    public void openPrivacyPolicy() {
        // Create a new intent and launch it with the activity
        Intent intent2 = new Intent(this, PrivacyPolicy.class);
        startActivity(intent2);
    }

    public void openAbout() {
        // Create a new intent and launch it with the activity
        Intent intent3 = new Intent(this, About.class);
        startActivity(intent3);
    }
}