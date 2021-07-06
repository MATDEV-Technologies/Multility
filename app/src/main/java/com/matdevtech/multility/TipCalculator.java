package com.matdevtech.multility;

// Imports
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.Objects;

// Main class
public class TipCalculator extends Fragment {
    // Class vars and consts
    private EditText total_price, percentage_tip;
    private TextView tip_result;
    private Button tip_button;

    public TipCalculator() {
        // Required empty public constructor
    }

    // Fragment init
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Objects.requireNonNull(((NavigationBar) Objects.requireNonNull(getActivity())).getSupportActionBar()).setTitle("Tip Calculator");
    }

    // Fragment view init
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tip_calculator, container, false);
    }

    // Fragemnt view management
    @Override
    public void onViewCreated(@SuppressWarnings("NullableProblems") View view, @Nullable Bundle savedInstanceState) {
        //noinspection ConstantConditions
        total_price = getView().findViewById(R.id.total_price_input_bar);
        percentage_tip = getView().findViewById(R.id.tip_percentage_input_bar);
        tip_button = getView().findViewById(R.id.tip_calculator_button);
        tip_result = getView().findViewById(R.id.calculated_tip_text);

        // Tip calculation and display
        tip_button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint({"SetTextI18n", "DefaultLocale"})
            @Override
            public void onClick(View view) {
                if (total_price.getText().toString().length() == 0) {
                    total_price.setText("");
                }

                if (percentage_tip.getText().toString().length() == 0) {
                    percentage_tip.setText("");
                }

                float total_price_int;
                float percentage_tip_int;
                float calculated_tip;
                double rounded_tip;

                try{
                    total_price_int = Float.parseFloat(total_price.getText().toString());
                    percentage_tip_int = Float.parseFloat(percentage_tip.getText().toString());

                    calculated_tip = (total_price_int * (percentage_tip_int / 100));
                    rounded_tip = Math.round(calculated_tip * 100.0) / 100.0;

                    tip_result.setText("TIP:  $" + String.format("%.2f", rounded_tip));
                }catch(Exception e){
                    Toast.makeText(getActivity(), "Enter Price/Percentage Info!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Check which items are selected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Objects.requireNonNull(super.getActivity()).onBackPressed(); // Goto -> parent activity -> main
            total_price.onEditorAction(EditorInfo.IME_ACTION_DONE);
            percentage_tip.onEditorAction(EditorInfo.IME_ACTION_DONE);
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}