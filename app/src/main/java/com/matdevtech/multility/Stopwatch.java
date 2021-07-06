package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

// Main class
public class Stopwatch extends Fragment {
    // Class vars and consts
    private Chronometer chronometer;
    private long pauseOffset;
    @SuppressWarnings("FieldCanBeLocal")
    private Button start_button, pause_button, reset_button;
    private boolean running;

    public Stopwatch() {
        // Required empty public constructor
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Stopwatch");
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

    // Fragment view management
    @Override
    public void onViewCreated(@SuppressWarnings("NullableProblems") View view, @Nullable Bundle savedInstanceState) {
        //noinspection ConstantConditions
        chronometer = getView().findViewById(R.id.stopwatch_chronometer);
        start_button = getView().findViewById(R.id.stopwatch_start_button);
        pause_button = getView().findViewById(R.id.stopwatch_pause_button);
        reset_button = getView().findViewById(R.id.stopwatch_reset_button);

        // Check and listen for actions on all the buttons
        start_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    running = true;
                }
            }
        });

        pause_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (running) {
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;
                }
            }
        });

        reset_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
            }
        });
    }
}