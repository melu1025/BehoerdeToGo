package com.example.behoerdetogo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AntragDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrag_detail);

        TextView titelTextView = findViewById(R.id.titelTextView);
        TextView beschreibungTextView = findViewById(R.id.beschreibungTextView);
        Button downloadPdfButton = findViewById(R.id.downloadPdfButton);

        Intent intent = getIntent();
        String titel = intent.getStringExtra("titel");
        String beschreibung = intent.getStringExtra("beschreibung");

        titelTextView.setText(titel);
        beschreibungTextView.setText(beschreibung);

        downloadPdfButton.setOnClickListener(v -> {
            Uri uri = Uri.parse("file:///android_asset/Personalausweis_Antrag.pdf");
            Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
            pdfIntent.setDataAndType(uri, "application/pdf");
            pdfIntent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(pdfIntent);
        });
    }
}
