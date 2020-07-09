package com.matdevtech.multility;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

// Main class
public class MainActivity extends AppCompatActivity {

    // Activity init
    // GLOBAL NOTE: all Android methods must be overidden to be called by the framework and function in the application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Sets the activity layout to the one belonging to MainActivity
    }

    // Options menu for going to settings init
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the main_menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_goto_settings, menu);
        return true;
    }

    // Check if the settings icon is selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            openSettingsActivity(); // Goto -> settings
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void openSettingsActivity() {
        // Create a new intent and launch it with the activity
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}