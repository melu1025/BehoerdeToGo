package com.example.behoerdetogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button antraegeButton;
    private Button kontoverwaltungButton;
    private Button terminbuchungButton;
    private Button auskunftButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        antraegeButton = findViewById(R.id.antraegeButton);
        kontoverwaltungButton = findViewById(R.id.kontoverwaltungButton);
        terminbuchungButton = findViewById(R.id.terminbuchungButton);
        auskunftButton = findViewById(R.id.auskunftButton);

        antraegeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        kontoverwaltungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent für Kontoverwaltung starten
            }
        });

        terminbuchungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent für Terminbuchung starten
            }
        });

        auskunftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent für Auskunft starten
            }
        });
    }
}
