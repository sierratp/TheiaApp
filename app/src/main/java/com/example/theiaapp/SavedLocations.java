package com.example.theiaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

public class SavedLocations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_locations); // Create a separate layout for this screen

        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Closes the current activity
        });

        // english onclick
        Button englishButton = findViewById(R.id.English_button);
        englishButton.setOnClickListener(v-> {
            Intent intent = new Intent(SavedLocations.this, Method.class);
            startActivity(intent);
        });

        // gym onclick
        Button gymButton = findViewById(R.id.Gym_button);
        gymButton.setOnClickListener(v-> {
            Intent intent = new Intent(SavedLocations.this, Method.class);
            startActivity(intent);
        });

        // cafeteria onclick
        Button cafeteriaButton = findViewById(R.id.Cafeteria_button);
        cafeteriaButton.setOnClickListener(v-> {
            Intent intent = new Intent(SavedLocations.this, Method.class);
            startActivity(intent);
        });

        // english onclick
        Button mathButton = findViewById(R.id.Math_button);
        mathButton.setOnClickListener(v-> {
            Intent intent = new Intent(SavedLocations.this, Method.class);
            startActivity(intent);
        });

    }
}