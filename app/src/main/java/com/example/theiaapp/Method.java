package com.example.theiaapp;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.theiaapp.views.FirstPersonView;
import com.example.theiaapp.views.MapView;

import java.util.Locale;

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

    // Text to Speech Section
    private TextToSpeech tts;
    protected void onStart() {
        super.onStart();

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.US);
                speakText("Please choose a method to use, First Person View or Map View.");
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