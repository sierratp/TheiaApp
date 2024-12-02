package com.example.theiaapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Measurements extends AppCompatActivity {

    // Buttons declared at the class level
    private Button enableMetric;
    private Button enableImperial;
    private Button enableStride;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

        // Back button onclick handler
        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Closes the current activity

        // Initialize buttons
        enableMetric = findViewById(R.id.enable_metric_button);
        enableImperial = findViewById(R.id.enable_imperial_button);
        enableStride = findViewById(R.id.enable_stride_button);

        // Set button listeners
        enableMetric.setOnClickListener(v -> toggleExclusiveButton(enableMetric));
        enableImperial.setOnClickListener(v -> toggleExclusiveButton(enableImperial));
        enableStride.setOnClickListener(v -> toggleExclusiveButton(enableStride));
    }

    /**
     * Toggles the clicked button to "Enable" and resets others to "Disable".
     * @param clickedButton The button that was clicked.
     */
    private void toggleExclusiveButton(Button clickedButton) {
        if (!clickedButton.getText().toString().startsWith("Enable")) {
            clickedButton.setText(clickedButton.getText().toString().replace("Disable", "Enable"));
        }

        // Reset other buttons
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
