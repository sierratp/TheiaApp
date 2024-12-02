package com.example.theiaapp;

import android.os.Bundle;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // eye icon onclick handler
        ImageView eyeIcon = findViewById(R.id.eye_icon);
        eyeIcon.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);
        });

        // customize button onclick handler
        Button customizeButton = findViewById(R.id.customize_button);
        customizeButton.setOnClickListener(v -> {
            // Navigate to a new screen or perform an action
            Intent intent = new Intent(MainActivity.this, Customization.class);
            startActivity(intent);
        });
    }

    //text to speech section 
    private TextToSpeech tts;
    protected void onStart() {
        super.onStart();

        tts = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                tts.setLanguage(Locale.US);
                speakText("Welcome to Theia.");
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