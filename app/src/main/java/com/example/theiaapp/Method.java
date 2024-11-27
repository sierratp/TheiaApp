package com.example.theiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.theiaapp.views.FirstPersonView;
import com.example.theiaapp.views.MapView;

public class Method extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_method); // Create a separate layout for this screen

        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Closes the current activity
        });

        Button firstPerson = findViewById(R.id.first_person_button);
        firstPerson.setOnClickListener(v -> {
            Intent intent = new Intent(Method.this, FirstPersonView.class);
            startActivity(intent);
        });

        Button map = findViewById(R.id.map_button);
        map.setOnClickListener(v -> {
            Intent intent = new Intent(Method.this, MapView.class);
            startActivity(intent);
        });
    }
}