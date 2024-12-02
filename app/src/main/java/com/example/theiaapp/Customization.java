package com.example.theiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Customization extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization); // Create a separate layout for this screen

        // back onclick function
        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Closes the current activity
        });

        Button enableSpeech = findViewById(R.id.enable_speech_button);
        enableSpeech.setOnClickListener(v-> {
            Intent intent = new Intent(Customization.this, SpeakDestination.class);
            startActivity(intent);
        });

        // enable screen onclick handler
        Button enableScreen = findViewById(R.id.enable_screen_button);
        enableScreen.setOnClickListener(v-> {
            Intent intent = new Intent(Customization.this, Home.class);
            startActivity(intent);
        });

        Button measurements = findViewById(R.id.measurement_button);
        measurements.setOnClickListener(v-> {
            Intent intent = new Intent(Customization.this, Measurements.class);
            startActivity(intent);
        });

    }

    // Text to Speech Section
    private TextToSpeech tts;
    protected void onStart() {
        super.onStart();

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.US);
                speakText("Customization Page.");
            }
        });
    }

    private void speakText(String text) {
        if (tts != null) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    @Override
    protected void onStop() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
        super.onStop();
    }

}
