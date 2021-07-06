package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

// Main class
@SuppressWarnings("RedundantSuppression")
public class DailyFact extends Fragment {
    // Class vars and consts
    @SuppressLint("StaticFieldLeak")
    public static TextView fact_text;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private Button fact_button;

    public DailyFact() {
        // Required empty public constructor
    }

    // Fragment init
    public void onCreate() {
        setHasOptionsMenu(true);
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