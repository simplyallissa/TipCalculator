package edu.ucdenver.hertzallissa.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

import edu.ucdenver.hertzallissa.tipcalculator.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void calculate(View view) {
        double totalInput = 0;
        double taxInput =0;
        double tip = 0;
        double grandTotal;
        double total;
        try {
            totalInput = Double.parseDouble(binding.totalAmountTextInput.getText().toString());
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Input must be a number", Toast.LENGTH_SHORT).show();
        }

        try {
            taxInput = Double.parseDouble(binding.taxAmountTextInput.getText().toString());
        }
        catch (NumberFormatException ex) {
            Toast.makeText(this, "Input must be a number", Toast.LENGTH_SHORT).show();
        }

        total = totalInput + taxInput;
        if (binding.radioButton5.isChecked()) {
            tip = total * .05;
        }
        else if (binding.radioButton10.isChecked()) {
            tip = total * .1;
        }
        else if (binding.radioButton20.isChecked()) {
            tip = total * .20;
        }

        grandTotal = totalInput + taxInput + tip;

        DecimalFormat precision = new DecimalFormat("$#,##0.00");
        binding.tipResult.setText(precision.format(tip));
        binding.totalResult.setText(precision.format(grandTotal));


    }

    public void clearClicked(View view) {
        com.example.tipcalculator.ClearFormDialog clearFormDialog = new com.example.tipcalculator.ClearFormDialog();
        clearFormDialog.show(getSupportFragmentManager(), "");
    }

    public void clearForm () {
        binding.totalAmountTextInput.setText("");
        binding.taxAmountTextInput.setText("");
        binding.tipResult.setText("$0.00");
        binding.totalResult.setText("$0.00");

        binding.radioButton0.setChecked(true);

    }
}