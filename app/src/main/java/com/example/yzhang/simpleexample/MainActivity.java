package com.example.yzhang.simpleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewCalculate;
    private TextView textViewTitle;
    private EditText editTextHeight;
    private EditText editTextWeight;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new MainViewModel();
        textViewCalculate = (TextView) findViewById(R.id.textViewCalculate);
        textViewCalculate.setOnClickListener(this);
        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        editTextHeight = (EditText) findViewById(R.id.editTextHeight);
        editTextWeight = (EditText) findViewById(R.id.editTextWeight);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.textViewCalculate) {
            String inputHeight = editTextHeight.getText().toString();
            String inputWeight = editTextWeight.getText().toString();
            if (inputHeight.isEmpty() || inputWeight.isEmpty()) {
                textViewTitle.setText(R.string.error_input);
            } else {
                float height = Float.parseFloat(inputHeight);
                float weight = Float.parseFloat(inputWeight);
                String bmi = viewModel.getBMI(height, weight);
                String result = getText(R.string.bmi_title) + " " + bmi;
                textViewTitle.setText(result);
            }
        }
    }
}
