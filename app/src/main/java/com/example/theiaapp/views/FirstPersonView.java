package com.example.theiaapp.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theiaapp.R;

public class FirstPersonView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_person);

        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Get the measurement type from SharedPreferences
        String measurementType = getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
                .getString("measurement_type", "Metric"); // Default to Metric

        // Update the navigation text based on the measurement type
        TextView navigationText = findViewById(R.id.navigation_text);
        if (measurementType != null) {
            switch (measurementType) {
                case "Metric":
                    navigationText.setText("In 20 meters, turn left.");
                    break;
                case "Imperial":
                    navigationText.setText("In 20 feet, turn left.");
                    break;
                case "Stride":
                    navigationText.setText("In 20 strides, turn left.");
                    break;
            }
        }

        // Schedule BlockedPath to open after 5 seconds
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(FirstPersonView.this, BlockedPathView.class);
            startActivity(intent);
        }, 5000); // 5000 milliseconds = 5 seconds
    }
}
