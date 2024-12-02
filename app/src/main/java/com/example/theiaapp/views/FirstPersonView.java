package com.example.theiaapp.views;

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
        setContentView(R.layout.activity_first_person); // Create a separate layout for this screen

        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish()); // Closes the current activity

//        // Schedule EmergencyCallView to open after 5 seconds
//        new Handler().postDelayed(() -> {
//            Intent intent = new Intent(FirstPersonView.this, EmergencyCallView.class); // Ensure correct target
//            startActivity(intent);
//        }, 5000); // 5000 milliseconds = 5 seconds
    }
}