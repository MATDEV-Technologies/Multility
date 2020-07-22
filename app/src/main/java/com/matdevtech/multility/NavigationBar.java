package com.matdevtech.multility;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

// Main class
public class NavigationBar extends AppCompatActivity {

    // Class vars
    private static final String TAG = NavigationBar.class.getSimpleName();
    String fragment_int;
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;

    // Menu init
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        bottomNav = findViewById(R.id.bottom_nav);

        Intent intent = getIntent();
        fragment_int = intent.getStringExtra(MainActivity.FRAGMENT_INT);

        // Check each fragment selection
        assert fragment_int != null; // DEBUG
        switch (fragment_int) {
            case "1":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.tip_calculator_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    TipCalculator tipCalculator = new TipCalculator();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, tipCalculator)
                            .commit();
                }
                break;
            case "2":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.notepad_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    Notepad notepad = new Notepad();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, notepad)
                            .commit();
                }
                break;
            case "3":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.stopwatch_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    Stopwatch stopwatch = new Stopwatch();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, stopwatch)
                            .commit();
                }
                break;
            case "4":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.password_generator_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    PasswordGenerator passwordGenerator = new PasswordGenerator();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, passwordGenerator)
                            .commit();
                }
                break;
            case "5":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.daily_fact_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    DailyFact dailyFact = new DailyFact();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, dailyFact)
                            .commit();
                }
                break;
            case "6":
                if (savedInstanceState == null) {
                    bottomNav.setItemSelected(R.id.trending_news_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    TrendingNews trendingNews = new TrendingNews();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, trendingNews)
                            .commit();
                }
                break;
        }

        // Check and perform fragment changes
        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;

                // Switch to new fragments based on case
                switch (id){
                    case R.id.tip_calculator_navbar:
                        fragment = new TipCalculator();
                        break;
                    case R.id.notepad_navbar:
                        fragment = new Notepad();
                        break;
                    case R.id.stopwatch_navbar:
                        fragment = new Stopwatch();
                        break;
                    case R.id.password_generator_navbar:
                        fragment = new PasswordGenerator();
                        break;
                    case R.id.daily_fact_navbar:
                        fragment = new DailyFact();
                        break;
                    case R.id.trending_news_navbar:
                        fragment = new TrendingNews();
                        break;
                }

                // x != null -> exists
                if (fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating fragment"); // DEBUG
                }
            }
        });
    }
}