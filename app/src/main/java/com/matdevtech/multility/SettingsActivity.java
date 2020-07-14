package com.matdevtech.multility;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

// Main class
public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Class vars
    @SuppressWarnings("FieldCanBeLocal")
    private Button button1;
    @SuppressWarnings("FieldCanBeLocal")
    private Button button2;
    Spinner location;

    // Class consts
    public static final String SHARED_PREFS = "sharedPrefs";
    public static String COLOR_TEXT = "colorText";
    public static String LOCATION_TEXT = "locationText";

    // Activity init
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DO NOT DELETE COMMENTS

        // UtilsTheme.onApplicationCreateSetTheme(this);
        setContentView(R.layout.activity_settings);

        // Spinner drop down init
        Spinner spinner = findViewById(R.id.color_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, R.layout.spinner_styles);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_styles);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        // Spinner drop down init
        location = findViewById(R.id.country_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.countries, R.layout.spinner_styles);
        adapter2.setDropDownViewResource(R.layout.spinner_dropdown_styles);
        location.setAdapter(adapter2);
        location.setOnItemSelectedListener(this);

        // Button init(s)
        // Grab IDs and listen for clicks/taps
        button1 = findViewById(R.id.terms_of_service_button);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTermsOfService();
            }
        });
        button2 = findViewById(R.id.privacy_policy_button);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPrivacyPolicy();
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

    // Cases for changing the accent color by spinner (currently disabled)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Theming is disabled for now; DO NOT REMOVE THE COMMENTS OR METHODS

//        Spinner spinner = findViewById(R.id.color_spinner);
////        String currentColor;
//        String text = spinner.getSelectedItem().toString();
//        switch (text) {
//            case "Choose Colour":
//                break;
//            case "Red":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_RED);
////                Drawable unwrappedDrawable = AppCompatResources.getDrawable(getBaseContext(), R.drawable.ic_baseline_attach_money_24);
////                Drawable wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable);
////                DrawableCompat.setTint(wrappedDrawable, getResources().getColor(R.color.redPrimary));
//                // Normally apply to all drawables and themes (the other branches of the switch statement)
//                // DO NOT REMOVE THESE COMMENTS
//                break;
//            case "Orange":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_ORANGE);
//                break;
//            case "Yellow":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_YELLOW);
//                break;
//            case "Green":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_DEFAULT);
//                break;
//            case "Blue":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_BLUE);
//                break;
//            case "Purple":
//                UtilsTheme.changeToTheme(this, UtilsTheme.THEME_PURPLE);
//                break;
//            // Maybe add a default branch
//        }

        // IMPLEMENTATION OF LOCATION SPINNER
        location = findViewById(R.id.country_spinner);
        LOCATION_TEXT = location.getSelectedItem().toString();
        // LATER, ADD SHARED PREFERENCES TO STORE THE CURRENT SPINNER CHOICE
    }

    // Part of and required by onItemSelected() and the main clas
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // pass BUT DO NOT DELETE; REQUIRED BY THE MAIN CLASS
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
}