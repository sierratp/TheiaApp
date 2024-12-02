package com.example.theiaapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.speech.tts.TextToSpeech;

public class SpeakDestination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak_destination);

        // back button
        TextView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            finish(); // Closes the current activity
        });
    }

    // start of text section
    private TextToSpeech tts;
    @Override
    protected void onStart() {
        super.onStart();

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.speak("Press to Speak Destination.", TextToSpeech.QUEUE_FLUSH, null, null);
            }
        });
    }

}