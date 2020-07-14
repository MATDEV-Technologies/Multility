package com.matdevtech.multility;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Stopwatch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Stopwatch extends Fragment {

    private Chronometer chronometer;
    private long pauseOffset;
    private Button start_button, pause_button, reset_button;
    private boolean running;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam1;
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private String mParam2;

    public Stopwatch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Stopwatch.
     */
    // TODO: Rename and change types and number of parameters
    @SuppressWarnings("unused")
    public static Stopwatch newInstance(String param1, String param2) {
        Stopwatch fragment = new Stopwatch();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // TODO: add new titles to strings.xml
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Stopwatch");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

    @Override
    public void onViewCreated(@SuppressWarnings("NullableProblems") View view, @Nullable Bundle savedInstanceState) {
        //noinspection ConstantConditions
        chronometer = getView().findViewById(R.id.stopwatch_chronometer);
        start_button = getView().findViewById(R.id.stopwatch_start_button);
        pause_button = getView().findViewById(R.id.stopwatch_pause_button);
        reset_button = getView().findViewById(R.id.stopwatch_reset_button);

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