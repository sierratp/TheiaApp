package com.example.theiaapp;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Measurements extends AppCompatActivity {

    private Button enableMetric;
    private Button enableImperial;
    private Button enableStride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

        // Back button onclick handler
        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Initialize buttons
        enableMetric = findViewById(R.id.enable_metric_button);
        enableImperial = findViewById(R.id.enable_imperial_button);
        enableStride = findViewById(R.id.enable_stride_button);

        // Set button listeners
        enableMetric.setOnClickListener(v -> {
            saveMeasurementType("Metric");
            toggleExclusiveButton(enableMetric);
        });

        enableImperial.setOnClickListener(v -> {
            saveMeasurementType("Imperial");
            toggleExclusiveButton(enableImperial);
        });

        enableStride.setOnClickListener(v -> {
            saveMeasurementType("Stride");
            toggleExclusiveButton(enableStride);
        });
    }

    private void saveMeasurementType(String type) {
        getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
                .edit()
                .putString("measurement_type", type)
                .apply();
    }

    private void toggleExclusiveButton(Button clickedButton) {
        if (!clickedButton.getText().toString().startsWith("Enable")) {
            clickedButton.setText(clickedButton.getText().toString().replace("Disable", "Enable"));
        }

        if (clickedButton != enableMetric) {
            enableMetric.setText("Disable Metric");
        }
        if (clickedButton != enableImperial) {
            enableImperial.setText("Disable Imperial");
        }
        if (clickedButton != enableStride) {
            enableStride.setText("Disable Stride");
        }
    }
}
