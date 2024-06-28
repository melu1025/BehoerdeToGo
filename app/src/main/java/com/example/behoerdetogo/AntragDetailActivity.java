package com.example.behoerdetogo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/** Klasse für die AntragsDetailActivity */
public class AntragDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrag_detail);

        TextView titelTextView = findViewById(R.id.titelTextView);
        TextView beschreibungTextView = findViewById(R.id.beschreibungTextView);

        Intent intent = getIntent();
        String titel = intent.getStringExtra("titel");
        String beschreibung = intent.getStringExtra("beschreibung");

        titelTextView.setText(titel);
        beschreibungTextView.setText(beschreibung);

    }
}
