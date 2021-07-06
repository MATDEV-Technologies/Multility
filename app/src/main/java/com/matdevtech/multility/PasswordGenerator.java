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

// Main class
@SuppressLint("StaticFieldLeak")
public class PasswordGenerator extends Fragment {
    // Class vars and consts
    private CheckBox include_lowercase, include_uppercase, include_numbers, include_symbols;
    private TextView password_generate_result;

    public PasswordGenerator() {
        // Required empty public constructor
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
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