package com.matdevtech.multility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class NavigationBar extends AppCompatActivity {

    private static final String TAG = NavigationBar.class.getSimpleName();
    String fragment_int;
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        bottomNav = findViewById(R.id.bottom_nav);

        Intent intent = getIntent();
        fragment_int = intent.getStringExtra(MainActivity.FRAGMENT_INT);

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
                    bottomNav.setItemSelected(R.id.unit_converter_navbar, true);
                    fragmentManager = getSupportFragmentManager();
                    UnitConverter unitConverter = new UnitConverter();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, unitConverter)
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

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.tip_calculator_navbar:
                        fragment = new TipCalculator();
                        break;
                    case R.id.notepad_navbar:
                        fragment = new Notepad();
                        break;
                    case R.id.unit_converter_navbar:
                        fragment = new UnitConverter();
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

                if (fragment!=null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating fragment");
                }
            }
        });
//        public static void setActionBarTitle(String title) {
//            getSupportActionBar().setTitle(title);
//        }
    }
}