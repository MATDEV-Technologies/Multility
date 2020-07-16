package com.matdevtech.multility;

// TODO: Maybe add mutliple notes and autosave

// Imports
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notepad#newInstance} factory method to
 * create an instance of this fragment.
 */
@SuppressWarnings("FieldCanBeLocal")
public class Notepad extends Fragment {

    // Class vars and consts
    private EditText notepad_edit;
    @SuppressWarnings("unused")
    private Menu notepad_save;
    private static String noteText;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String NOTE = "note";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam1;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam2;

    public Notepad() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Notepad.
     */
    // TODO: Rename and change types and number of parameters
    @SuppressWarnings("unused")
    public static Notepad newInstance(String param1, String param2) {
        Notepad fragment = new Notepad();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // TODO: add new titles to strings.xml
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Notepad");
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        inflater.inflate(R.menu.menu_notepad_clear, menu);
        inflater.inflate(R.menu.menu_notepad_save, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notepad, container, false);
    }

    // Fragemnt view management
    @Override
    public void onViewCreated(@SuppressWarnings("NullableProblems") View view, @Nullable Bundle savedInstanceState) {
        //noinspection ConstantConditions
        notepad_edit = getView().findViewById(R.id.notepad_edit);
        notepad_save = getView().findViewById(R.id.action_notepad_save);

        loadData();
        try {
            ((Activity) Objects.requireNonNull(getContext())).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((EditText) notepad_edit).setText(noteText);
                }
            });
        } catch (Exception e) {
            e.printStackTrace(); // DEBUG
        }
    }

    public void saveData() {
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(NOTE, notepad_edit.getText().toString());
        editor.apply();

        Toast.makeText(getContext(), "Note Saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData() {
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        noteText = sharedPreferences.getString(NOTE, ""); // Remains null for some reason on Debug
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            //noinspection ConstantConditions
            super.getActivity().onBackPressed(); // Goto -> parent activity -> main
            notepad_edit.onEditorAction(EditorInfo.IME_ACTION_DONE);
        } else if (item.getItemId() == R.id.action_notepad_save) {
            saveData();
        } else if (item.getItemId() == R.id.action_notepad_clear){
            notepad_edit.setText("");
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}