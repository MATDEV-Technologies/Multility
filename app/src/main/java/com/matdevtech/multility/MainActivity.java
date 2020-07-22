package com.matdevtech.multility;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

// Main class
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // Class const(s)
    public static final String FRAGMENT_INT = "com.matdevtech.multility.FRAGMENT_INT";

    // Activity init
    // GLOBAL NOTE: all Android methods must be overidden to be called by the framework and function in the application
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Sets the activity layout to the one belonging to MainActivity

        // INITIALIZE MENU CARDS BY THEIR IDs
        CardView tipCalculatorCard = findViewById(R.id.tip_calculator_card);
        CardView notepadCard = findViewById(R.id.notepad_card);
        CardView unitConverterCard = findViewById(R.id.stopwatch_card);
        CardView passwordGeneratorCard = findViewById(R.id.password_generator_card);
        CardView dailyFactCard = findViewById(R.id.daily_fact_card);
        CardView trendingNewsCard = findViewById(R.id.trending_news_card);

        // ADD CARD CLICK LISTENERS
        tipCalculatorCard.setOnClickListener(this);
        notepadCard.setOnClickListener(this);
        unitConverterCard.setOnClickListener(this);
        passwordGeneratorCard.setOnClickListener(this);
        dailyFactCard.setOnClickListener(this);
        trendingNewsCard.setOnClickListener(this);
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

    // Main menu click/tap checks
    @Override
    public void onClick(View v) {

        String fragment_int;

        // Check for and switch to new fragments
        switch (v.getId()) {
            case R.id.tip_calculator_card:
                fragment_int = "1";
                Intent navigation1 = new Intent(this, NavigationBar.class);
                navigation1.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation1);
                break;
            case R.id.notepad_card:
                Intent navigation2 = new Intent(this, NavigationBar.class);
                fragment_int = "2";
                navigation2.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation2);
                break;
            case R.id.stopwatch_card:
                Intent navigation3 = new Intent(this, NavigationBar.class);
                fragment_int = "3";
                navigation3.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation3);
                break;
            case R.id.password_generator_card:
                Intent navigation4 = new Intent(this, NavigationBar.class);
                fragment_int = "4";
                navigation4.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation4);
                break;
            case R.id.daily_fact_card:
                Intent navigation5 = new Intent(this, NavigationBar.class);
                fragment_int = "5";
                navigation5.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation5);
                break;
            case R.id.trending_news_card:
                Intent navigation6 = new Intent(this, NavigationBar.class);
                fragment_int = "6";
                navigation6.putExtra(FRAGMENT_INT,fragment_int);
                startActivity(navigation6);
                break;
        }
    }
}