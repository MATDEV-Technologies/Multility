package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
//import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// Main class
public class SettingsActivity extends AppCompatActivity {

    @SuppressWarnings("unused")
    public static String API_COUNTRY_STRING;

    SharedPreferences LastSelect;
    SharedPreferences LastSelectColour;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor coloreditor;

    // Class vars
    @SuppressWarnings("FieldCanBeLocal")
    private Button button1;
    @SuppressWarnings("FieldCanBeLocal")
    private Button button2;
    Spinner location;
    Spinner color;
    @SuppressWarnings("FieldCanBeLocal")
    private Button button3;

    // Class consts
    @SuppressWarnings("unused")
    public static String COLOR_TEXT = "colorText";
    public static String LOCATION_TEXT = "locationText";

    // Activity init
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DO NOT DELETE COMMENTS

        // INITIALIZE SHARED PREFERENCES FOR SPINNERS
        LastSelect = getSharedPreferences("LastSetting", Context.MODE_PRIVATE);
        editor = LastSelect.edit();
        final int LastClick = LastSelect.getInt("LastClick",0);

        LastSelectColour = getSharedPreferences("LastSettingColour", Context.MODE_PRIVATE);
        coloreditor = LastSelectColour.edit();
        final int LastClickColour = LastSelectColour.getInt("LastClickColour",0);

        setContentView(R.layout.activity_settings);

        // Spinner drop down init
        color = findViewById(R.id.color_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.spinner_styles);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_styles);
        color.setAdapter(adapter);
        color.setSelection(LastClickColour);
        color.setOnItemSelectedListener(new ColourSpinnerClass());

        // Spinner drop down init
        location = findViewById(R.id.country_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.countries, R.layout.spinner_styles);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_styles);
        location.setAdapter(adapter2);
        location.setSelection(LastClick);
        location.setOnItemSelectedListener(new LocationSpinnerClass());

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

    class ColourSpinnerClass implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            coloreditor.putInt("LastClickColour",position).commit();

            color = findViewById(R.id.color_spinner);
            COLOR_TEXT = color.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class LocationSpinnerClass implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            editor.putInt("LastClick",position).commit();

            location = findViewById(R.id.country_spinner);
            LOCATION_TEXT = location.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
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