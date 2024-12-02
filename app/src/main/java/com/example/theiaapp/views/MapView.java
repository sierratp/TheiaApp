package com.example.theiaapp.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theiaapp.R;

public class MapView extends AppCompatActivity {

    private Handler handler = new Handler();
    private Runnable navigationRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view); // Create a separate layout for this screen

        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Schedule EmergencyCallView to open after 5 seconds
        navigationRunnable = () -> {
            Intent intent = new Intent(MapView.this, EmergencyCallView.class); // Ensure correct target
            startActivity(intent);
        };
        handler.postDelayed(navigationRunnable, 5000); // 5000 milliseconds = 5 seconds
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer if the activity is destroyed
        if (handler != null && navigationRunnable != null) {
            handler.removeCallbacks(navigationRunnable);
        }
    }
}
