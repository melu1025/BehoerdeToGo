package com.example.behoerdetogo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/** Klasse für die Home Activity */
public class HomeActivity extends AppCompatActivity {

    /** setzt onClick Listener für den antraegeButton */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button antraegeButton = findViewById(R.id.antraegeButton);

        antraegeButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AntraegeActivity.class);
            startActivity(intent);
        });

    }
}
