package com.matdevtech.multility;

//////// GLOBAL NOTE: Do NOT delete any comments right now since there is some debugging to be done to save the NOTE text in SharedPrefs ////////

// TODO: Figure out how to properly store the note text in SharedPreferences (check null object reference exception below)

// Imports
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.Toast;
import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
// import android.widget.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    private Menu notepad_save;
    private String file = "note.txt";
    private String fileContents;
    private String localTempContents;
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

//        try {
//            open();
//        } catch (Exception e) {
//            e.printStackTrace(); // DEBUG
//        }

//        try {
//            notepad_edit.setText(localTempContents);
//        } catch (Exception e) {
//            e.printStackTrace(); //DEBUG
//        }
        final String textio = loadData(); // TEMP for DEBUG
        /* Text not saved or updated due to:
        java.lang.NullPointerException: Attempt to invoke virtual method
        'void android.widget.EditText.setText(java.lang.CharSequence)' on a null object reference
         */
        try {
//            notepad_edit.setText(localTempContents);
//            notepad_edit.setText(noteText);
            ((Activity) Objects.requireNonNull(getContext())).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ((EditText) notepad_edit).setText(textio);
                }
            });
        } catch (Exception e) {
            e.printStackTrace(); // DEBUG
        }
//        notepad_edit.setText(noteText);
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
    }

//    public void writeFile(String fileName) throws IOException {
//        String textToSave = notepad_edit.getText().toString();
//
//        //noinspection TryWithIdenticalCatches
//        try {
//            FileOutputStream fileOutputStream = Objects.requireNonNull(getContext()).openFileOutput(fileName, Context.MODE_PRIVATE);
//            fileOutputStream.write(textToSave.getBytes());
//            fileOutputStream.close();
//
//            Toast.makeText(getContext(), "Text Saved", Toast.LENGTH_SHORT).show();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace(); // DEBUG
//        } catch (IOException e) {
//            e.printStackTrace(); // DEBUG
//        }
//    }
//    public boolean FileExists(String fname) {
//        File file = Objects.requireNonNull(getContext()).getFileStreamPath(fname);
//        return file.exists();
//    }
//
//    public void Save(String fileName) {
//        notepad_edit = Objects.requireNonNull(getView()).findViewById(R.id.notepad_edit);
//        try {
//            OutputStreamWriter out =
//                    new OutputStreamWriter(Objects.requireNonNull(getContext()).openFileOutput(fileName, 0));
//            out.write(notepad_edit.getText().toString());
//            out.close();
//            Toast.makeText(getContext(), "Text Saved", Toast.LENGTH_SHORT).show();
//        } catch (Throwable t) {
//            Log.e("NOTEPAD::", "Error saving"); // DEBUG
//        }
//    }

    public void save() {
        fileContents = notepad_edit.getText().toString();
        localTempContents = fileContents;

        //noinspection TryWithIdenticalCatches
        try {
            FileOutputStream fOut = Objects.requireNonNull(getContext()).openFileOutput(file, Context.MODE_PRIVATE);
            fOut.write(fileContents.getBytes());
            fOut.close();
            File fileDir = new File(getContext().getFilesDir(),file);
            Toast.makeText(getContext(), "Text Saved (debug::loc -  " + fileDir + ")", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

    public String loadData() {
        SharedPreferences sharedPreferences = Objects.requireNonNull(getContext()).getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        noteText = sharedPreferences.getString(NOTE, ""); // Remains null for some reason on Debug

        // Log data displays correct values though
        Log.d("loadData.sharedPreferences", Objects.requireNonNull(sharedPreferences.getString(NOTE, "")));
        Log.d("loadData.noteText", noteText);
        return noteText;
    }

//    public void updateViews() {
//        notepad_edit.setText(noteText);
//    }

//    public void open() {
//        //noinspection TryWithIdenticalCatches
//        try {
//            FileInputStream fIn = Objects.requireNonNull(getContext()).openFileInput(file);
//            int c;
//            String temp = "";
//
//            while ((c = fIn.read()) != -1) {
//                //noinspection StringConcatenationInLoop
//                temp += Character.toString((char) c);
//            }
//            notepad_edit.setText(temp);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public String Open(String fileName) {
//        String content = "";
//        if (FileExists(fileName)) {
//            //noinspection CatchMayIgnoreException
//            try {
//                InputStream in = Objects.requireNonNull(getContext()).openFileInput(fileName);
//                if ( in != null) {
//                    InputStreamReader tmp = new InputStreamReader( in );
//                    BufferedReader reader = new BufferedReader(tmp);
//                    String str;
//                    StringBuilder buf = new StringBuilder();
//                    while ((str = reader.readLine()) != null) {
//                        buf.append(str).append("\n");
//                    } in .close();
//                    content = buf.toString();
//                }
//            } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
//                Log.e("NOTEPAD::", "File not found"); // DEBUG
//            }
//        }
//        return content;
//    }

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