package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;
import java.util.Random;
//import android.view.Gravity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PasswordGenerator#newInstance} factory method to
 * create an instance of this fragment.
 */
// Main class
public class PasswordGenerator extends Fragment {
    // Class vars and consts
    @SuppressLint("StaticFieldLeak")
    private static CheckBox include_lowercase;
    @SuppressLint("StaticFieldLeak")
    private static CheckBox include_uppercase;
    @SuppressLint("StaticFieldLeak")
    private static CheckBox include_numbers;
    @SuppressLint("StaticFieldLeak")
    private static CheckBox include_symbols;
    @SuppressLint("StaticFieldLeak")
    private static TextView password_generate_result;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public PasswordGenerator() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PasswordGenerator.
     */
    // TODO: Rename and change types and number of parameters
    @SuppressWarnings({"unused", "RedundantSuppression"})
    public static PasswordGenerator newInstance(String param1, String param2) {
        PasswordGenerator fragment = new PasswordGenerator();
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
        if (getArguments() != null) //noinspection RedundantSuppression
        {
            // TODO: Rename and change types of parameters
            //noinspection unused
            String mParam1 = getArguments().getString(ARG_PARAM1);
            //noinspection unused
            String mParam2 = getArguments().getString(ARG_PARAM2);
        }
        // TODO: add new titles to strings.xml
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Password Generator");
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_generator, container, false);
    }

    // Fragemnt view management
    @Override
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        // Local vars
        include_lowercase = Objects.requireNonNull(getView()).findViewById(R.id.include_lowercase_checkbox);
        include_uppercase = getView().findViewById(R.id.include_uppercase_checkbox);
        include_numbers = getView().findViewById(R.id.include_numbers_checkbox);
        include_symbols = getView().findViewById(R.id.include_symbols_checkbox);
        Button password_generate_button = getView().findViewById(R.id.password_generator_button);
        password_generate_result = getView().findViewById(R.id.generated_password_result);

        // Listen for clicks/taps
        // TODO: add temporary storage and copy management
        password_generate_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                // Local vars
                char[] asciiLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
                char[] asciiUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                char[] numbers = "01234567890".toCharArray();
                char[] symbols = "!@#$%^&*()_+~`".toCharArray();
                char[] lowerUpper = ArrayUtils.addAll(asciiLower, asciiUpper);
                char[] lowerNumbers = ArrayUtils.addAll(asciiLower, numbers);
                char[] lowerSymbols = ArrayUtils.addAll(asciiLower, symbols);
                char[] upperNumbers = ArrayUtils.addAll(asciiUpper, numbers);
                char[] upperSymbols = ArrayUtils.addAll(asciiUpper, symbols);
                char[] numberSymbols = ArrayUtils.addAll(numbers, symbols);
                char[] lowUpNum = ArrayUtils.addAll(lowerUpper, numbers);
                char[] lowUpSym = ArrayUtils.addAll(lowerUpper, symbols);
                char[] lowNumSym = ArrayUtils.addAll(lowerNumbers, symbols);
                char[] upNumSym = ArrayUtils.addAll(upperNumbers, symbols);
                char[] lowUpNumSym = ArrayUtils.addAll(lowerUpper, numberSymbols);
                String generation = "";

                // Conditional tests for each combination of selected checkboxes
                if (include_lowercase.isChecked() && include_uppercase.isChecked() && include_numbers.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowUpNumSym.length);
                        char rnd_char = lowUpNumSym[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_uppercase.isChecked() && include_numbers.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(upNumSym.length);
                        char rnd_char = upNumSym[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_numbers.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowNumSym.length);
                        char rnd_char = lowNumSym[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_uppercase.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowUpSym.length);
                        char rnd_char = lowUpSym[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_uppercase.isChecked() && include_numbers.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowUpNum.length);
                        char rnd_char = lowUpNum[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_numbers.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(numberSymbols.length);
                        char rnd_char = numberSymbols[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_uppercase.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(upperSymbols.length);
                        char rnd_char = upperSymbols[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_uppercase.isChecked() && include_numbers.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(upperNumbers.length);
                        char rnd_char = upperNumbers[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowerSymbols.length);
                        char rnd_char = lowerSymbols[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_numbers.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowerNumbers.length);
                        char rnd_char = lowerNumbers[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_uppercase.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowerUpper.length);
                        char rnd_char = lowerUpper[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(asciiLower.length);
                        char rnd_char = asciiLower[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_uppercase.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(asciiUpper.length);
                        char rnd_char = asciiUpper[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_numbers.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(numbers.length);
                        char rnd_char = numbers[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_symbols.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(symbols.length);
                        char rnd_char = symbols[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                } else if (include_lowercase.isChecked() && include_uppercase.isChecked()) {
                    for (int x = 0; x <= 12; x++) {
                        int rnd = new Random().nextInt(lowerUpper.length);
                        char rnd_char = symbols[rnd];
                        generation = generation.concat(Character.toString(rnd_char));
                    }
                    password_generate_result.setText("PASSWORD:  " + generation);
                }

                password_generate_result.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        Toast.makeText(getActivity(), "Password Copied", Toast.LENGTH_SHORT).show();

                        ClipboardManager clipboard = (ClipboardManager) Objects.requireNonNull(getActivity()).getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Copied Password", password_generate_result.getText().toString().substring(11)); // COPIES ONLY THE PASSWORD TO THE PHONE'S CLIPBOARD
                        clipboard.setPrimaryClip(clip);

                        return false;
                    }
                });
            }
        });
    }
}