package com.matdevtech.multility;

// Imports
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

// Main class
public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // Global variables within the class and only accessible within the class
    private Button button1;
    private Button button2;

    // Activity init
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // DO NOT DELETE COMMENTS

        // UtilsTheme.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_settings);

        // Spinner drop down init
        Spinner spinner = findViewById(R.id.color_spinner); // maybe make global to the class
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item); // ArayAdapter to host all values
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The resources used for dropping down
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this); // Listen for selections

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

    // Cases for changing the accent color by spinner (currently disabled)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Theming is disabled for now; DO NOT REMOVE THE COMMENTS OR METHODS

//        Spinner spinner = findViewById(R.id.color_spinner);
////        String currentColor;
//        String text = spinner.getSelectedItem().toString();
//        switch (text) {
//            case "Choose Colour:":
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
    }

    // Part of and required by onItemSelected() and the main class
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