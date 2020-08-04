package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DailyFact#newInstance} factory method to
 * create an instance of this fragment.
 */
// Main class
public class DailyFact extends Fragment {
    // Class vars and consts
    @SuppressLint("StaticFieldLeak")
    public static TextView fact_text;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private Button fact_button;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public DailyFact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DailyFact.
     */
    // TODO: Rename and change types and number of parameters
    @SuppressWarnings("unused")
    public static DailyFact newInstance(String param1, String param2) {
        DailyFact fragment = new DailyFact();
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
            // TODO: Rename and change types of parameters
            //noinspection unused
            String mParam1 = getArguments().getString(ARG_PARAM1);
            //noinspection unused
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // TODO: add new titles to strings.xml
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Fact Generator");
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daily_fact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        fact_text = Objects.requireNonNull(getView()).findViewById(R.id.daily_fact_text);
        fact_button = Objects.requireNonNull(getView()).findViewById(R.id.daily_fact_button);

        DailyFactAPIFetch process = new DailyFactAPIFetch();
        process.execute();

        fact_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitPrefEdits")
            @Override
            public void onClick(View view) {
                DailyFactAPIFetch process = new DailyFactAPIFetch();
                process.execute();
            }
        });
    }
}