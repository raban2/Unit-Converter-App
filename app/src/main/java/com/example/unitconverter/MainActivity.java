package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Spinner fromSpinner, toSpinner;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.input_edit_text);
        fromSpinner = findViewById(R.id.from_spinner);
        toSpinner = findViewById(R.id.to_spinner);
        resultTextView = findViewById(R.id.result_text_view);

        Button convertButton = findViewById(R.id.convert_button);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
    }

    private void convert() {
        double inputValue = Double.parseDouble(inputEditText.getText().toString());

        String fromUnit = fromSpinner.getSelectedItem().toString();
        String toUnit = toSpinner.getSelectedItem().toString();

        double resultValue;

        if (fromUnit.equals("Milliliters") && toUnit.equals("Fluid Ounces")) {
            resultValue = inputValue * 0.033814;
        } else if (fromUnit.equals("Fluid Ounces") && toUnit.equals("Milliliters")) {
            resultValue = inputValue * 29.5735;
        } else if (fromUnit.equals("Grams") && toUnit.equals("Cups")) {
            resultValue = inputValue / 236.588;
        } else if (fromUnit.equals("Cups") && toUnit.equals("Grams")) {
            resultValue = inputValue * 236.588;
        } else {
            resultValue = inputValue;
        }

        String resultString = String.format("%.2f %s = %.2f %s", inputValue, fromUnit, resultValue, toUnit);

        resultTextView.setText(resultString);
    }
}
