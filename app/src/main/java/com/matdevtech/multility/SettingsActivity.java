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
import androidx.appcompat.app.AppCompatActivity;
//import android.widget.Toast;
//import androidx.annotation.NonNull;

// Main class
public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @SuppressWarnings("unused")
    public static String API_COUNTRY_STRING;

    public static int themeInt;

    SharedPreferences LastSelect;
    SharedPreferences LastSelectColour;
    SharedPreferences.Editor editor;
    SharedPreferences.Editor coloreditor;

    // Class vars
    @SuppressWarnings("FieldCanBeLocal")
    private Button button1;
    @SuppressWarnings("FieldCanBeLocal")
    private Button button2;
    Spinner color;
    @SuppressWarnings("FieldCanBeLocal")
    private Button button3;

    // Class consts
    @SuppressWarnings("unused")
    public static String COLOR_TEXT = "colorText";

    // Activity init
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


         UtilsTheme.onActivityCreateSetTheme(this);
//         UtilsTheme.onApplicationCreateSetTheme(this);

        // INITIALIZE SHARED PREFERENCES FOR SPINNERS
        LastSelect = getSharedPreferences("LastSetting", Context.MODE_PRIVATE);
        editor = LastSelect.edit();
        //noinspection unused
        final int LastClick = LastSelect.getInt("LastClick",0);

        LastSelectColour = getSharedPreferences("LastSettingColour", Context.MODE_PRIVATE);
        coloreditor = LastSelectColour.edit();
        final int LastClickColour = LastSelectColour.getInt("LastClickColour",0);

        UtilsTheme.onActivityCreateSetTheme(SettingsActivity.this);
        setContentView(R.layout.activity_settings);

        // Spinner drop down init
        color = findViewById(R.id.color_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.spinner_styles);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_styles);
        color.setAdapter(adapter);
        color.setSelection(LastClickColour);
        color.setOnItemSelectedListener(this);

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

    // Still technically disabled (working on finishing before release, just need to fix one tiny bug that constantly resets the activity)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

        switch (COLOR_TEXT) {
            case "Choose Colour":
                themeInt = 0;
                break;
            case "Red":
                themeInt = 1;
//                Drawable unwrappedDrawable = AppCompatResources.getDrawable(getBaseContext(), R.drawable.ic_baseline_attach_money_24);
//                Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
//                DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.redPrimary));
                // Normally apply to all drawables and themes (the other branches of the switch statement)
                // DO NOT REMOVE THESE COMMENTS
                break;
            case "Orange":
                themeInt = 2;
                break;
            case "Yellow":
                themeInt = 3;
                break;
            case "Green":
                themeInt = 4;
                break;
            case "Blue":
                themeInt = 5;
                break;
            case "Purple":
                themeInt = 6;
                break;
            // Maybe add a default branch
        }

        // IMPLEMENTATION OF COLOUR SPINNER
        coloreditor.putInt("LastClickColour", position).commit();

        color = findViewById(R.id.color_spinner);
        COLOR_TEXT = color.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // pass
    }

//        switch (COLOR_TEXT) {
//            case "Choose Colour:":
//                break;
//            case "Red":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_RED);
////                Drawable unwrappedDrawable = AppCompatResources.getDrawable(getBaseContext(), R.drawable.ic_baseline_attach_money_24);
////                Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
////                DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.redPrimary));
//                // Normally apply to all drawables and themes (the other branches of the switch statement)
//                // DO NOT REMOVE THESE COMMENTS
//                break;
//            case "Orange":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_ORANGE);
//                break;
//            case "Yellow":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_YELLOW);
//                break;
//            case "Green":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_GREEN);
//                break;
//            case "Blue":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_BLUE);
//                break;
//            case "Purple":
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_PURPLE);
//                break;
//            default:
//                UtilsTheme.changeToTheme(SettingsActivity.this, UtilsTheme.THEME_DEFAULT);
//        }
//    }


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