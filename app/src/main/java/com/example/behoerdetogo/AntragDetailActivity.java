package com.example.behoerdetogo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AntragDetailActivity extends AppCompatActivity {
    private TextView titelTextView;
    private TextView beschreibungTextView;
    private Button downloadPdfButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrag_detail);

        // Referenz auf die Views herstellen
        titelTextView = findViewById(R.id.titelTextView);
        beschreibungTextView = findViewById(R.id.beschreibungTextView);
        downloadPdfButton = findViewById(R.id.downloadPdfButton);

        // Intent-Extras abfragen
        Intent intent = getIntent();
        String titel = intent.getStringExtra("titel");
        String beschreibung = intent.getStringExtra("beschreibung");

        // TextViews setzen
        titelTextView.setText(titel);
        beschreibungTextView.setText(beschreibung);

        // Button für den PDF-Download konfigurieren
        downloadPdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Öffne die PDF-Datei (vorausgesetzt, sie befindet sich im assets-Ordner)
                Uri uri = Uri.parse("file:///android_asset/Personalausweis_Antrag.pdf");
                Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                pdfIntent.setDataAndType(uri, "application/pdf");
                pdfIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(pdfIntent);
            }
        });
    }
}
