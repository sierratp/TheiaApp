package com.example.theiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button enterDestination = findViewById(R.id.enter_destination_button);
        enterDestination.setOnClickListener(v-> {
            Intent intent = new Intent(Home.this, SpeakDestination.class);
            startActivity(intent);
        });

        // saved locations onclick function
        Button savedLocations = findViewById(R.id.saved_locations_button);
        savedLocations.setOnClickListener(v -> {
            Intent intent = new Intent(Home.this, SavedLocations.class);
            startActivity(intent);
        });

        // english onclick
        Button englishButton = findViewById(R.id.English_class_button);
        englishButton.setOnClickListener(v-> {
            Intent intent = new Intent(Home.this, Method.class);
            startActivity(intent);
        });

        // back onclick function
        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Closes the current activity
        });


    }
}
