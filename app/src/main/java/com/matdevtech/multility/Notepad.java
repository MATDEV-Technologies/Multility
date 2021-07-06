package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

public class Notepad extends Fragment {
    // Class vars
    private EditText notepad_edit;
    @SuppressWarnings("FieldMayBeFinal")
    private String noteText, SHARED_PREFS = "sharedPrefs", NOTE = "note";
    boolean bold_button_pressed = false, italic_button_pressed = false;

    public Notepad() {
        // Required empty public constructor
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Notepad");
    }

    // Options init
    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_notepad_clear, menu);
        inflater.inflate(R.menu.menu_notepad_save, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    // Fragment view init
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notepad, container, false);
    }

    // Fragemnt view management
    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        notepad_edit = Objects.requireNonNull(getView()).findViewById(R.id.notepad_edit);
        final ImageButton notepad_button1 = Objects.requireNonNull(getView()).findViewById(R.id.bold_button);
        ImageButton notepad_button2 = Objects.requireNonNull(getView()).findViewById(R.id.italic_button);

        notepad_button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                Typeface boldTypeFace = Typeface.defaultFromStyle(Typeface.BOLD);
                Typeface italicTypeFace = Typeface.defaultFromStyle(Typeface.ITALIC);
                Typeface regularTypeFace = Typeface.defaultFromStyle(Typeface.NORMAL);
                Typeface boldItalicTypeFace = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);
                bold_button_pressed = !bold_button_pressed;

                //noinspection PointlessBooleanExpression
                if ((bold_button_pressed == true) && (italic_button_pressed == false)) {
                    notepad_edit.setTypeface(boldTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((bold_button_pressed == false)  && (italic_button_pressed == false)) {
                    notepad_edit.setTypeface(regularTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((bold_button_pressed == true)  && (italic_button_pressed == true)) {
                    notepad_edit.setTypeface(boldItalicTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((bold_button_pressed == false)  && (italic_button_pressed == true)) {
                    notepad_edit.setTypeface(italicTypeFace);
                }
            }
        });

        notepad_button2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                Typeface boldTypeFace = Typeface.defaultFromStyle(Typeface.BOLD);
                Typeface italicTypeFace = Typeface.defaultFromStyle(Typeface.ITALIC);
                Typeface regularTypeFace = Typeface.defaultFromStyle(Typeface.NORMAL);
                Typeface boldItalicTypeFace = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);
                italic_button_pressed = !italic_button_pressed;

                //noinspection PointlessBooleanExpression
                if ((italic_button_pressed == true) && (bold_button_pressed == false)) {
                    notepad_edit.setTypeface(italicTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((italic_button_pressed == false)  && (bold_button_pressed == false)) {
                    notepad_edit.setTypeface(regularTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((italic_button_pressed == true)  && (bold_button_pressed == true)) {
                    notepad_edit.setTypeface(boldItalicTypeFace);
                }

                //noinspection PointlessBooleanExpression
                if ((italic_button_pressed == false)  && (bold_button_pressed == true)) {
                    notepad_edit.setTypeface(boldTypeFace);
                }
            }
        });

        // Load and update EditText if there was a saved note
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        noteText = sharedPreferences.getString(NOTE, "");
        bold_button_pressed = sharedPreferences.getBoolean("Bold Button State",bold_button_pressed);
        italic_button_pressed = sharedPreferences.getBoolean("Italic Button State",italic_button_pressed);
        try {
            ((Activity) Objects.requireNonNull(getContext())).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    notepad_edit.setText(noteText);
                    if ((bold_button_pressed) && (italic_button_pressed)) {
                        notepad_edit.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));
                    } else if ((!bold_button_pressed) && (!italic_button_pressed)) {
                        notepad_edit.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                    } else if (italic_button_pressed) {
                        notepad_edit.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
                    } else //noinspection ConstantConditions
                        if (bold_button_pressed) {
                            notepad_edit.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                        }
                }
            });
        } catch (Exception ignored) { }
    }

    // SharedPrefs save EditText content
    public void saveData(boolean hidden) {
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("Bold Button State",bold_button_pressed);
        editor.putBoolean("Italic Button State",italic_button_pressed);
        editor.putString(NOTE, notepad_edit.getText().toString());
        editor.apply();

        // Hide info bubble
        if (!hidden) {
            Toast.makeText(getContext(), "Note Saved", Toast.LENGTH_SHORT).show();
        }
    }

    // Check which options are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // TODO: Maybe add a clear all on file and save action
            //noinspection ConstantConditions
            super.getActivity().onBackPressed(); // Goto -> parent activity -> main
            notepad_edit.onEditorAction(EditorInfo.IME_ACTION_DONE);
        } else if (item.getItemId() == R.id.action_notepad_save) {
            saveData(false);
        } else if (item.getItemId() == R.id.action_notepad_clear){
            notepad_edit.setText("");
//            saveData(true);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}