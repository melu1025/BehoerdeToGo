package com.example.behoerdetogo;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Activity für das anzeigen der Antraege */
public class AntraegeActivity extends AppCompatActivity {
    private List<Antrag> antraege;
    private AntragAdapter adapter;

    /** on Create Methode für die RegistrierungsActivity
     * Variablen werden Elementen in der XML Datei zugewiesesn */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        antraege = new ArrayList<>();
        antraege.add(new Antrag("Personalausweis verlängern", "Beantragen Sie die Verlängerung Ihres Personalausweises.", 2));
        antraege.add(new Antrag("Wohnort ummelden", "Melden Sie Ihren Wohnsitz um, wenn Sie umgezogen sind.", 1));
        antraege.add(new Antrag("Reisepass anfordern", "Beantragen Sie einen neuen Reisepass für internationale Reisen.", 3));
        antraege.add(new Antrag("Fahrzeug anmelden", "Melden Sie ein neu erworbenes Fahrzeug an.", 2));
        antraege.add(new Antrag("Kindergeld beantragen", "Beantragen Sie staatliches Kindergeld.", 1));
        antraege.add(new Antrag("Gewerbe anmelden", "Melden Sie ein neues Gewerbe an.", 3));
        antraege.add(new Antrag("Steuererklärung einreichen", "Reichen Sie Ihre jährliche Steuererklärung ein.", 2));
        antraege.add(new Antrag("Bauplan genehmigen lassen", "Beantragen Sie die Genehmigung für einen Bauplan.", 1));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AntragAdapter(antraege);
        recyclerView.setAdapter(adapter);
    }

    /** on Create Methode für das Menu zur Sortierung */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /** Funktion für die Auswahl der Sortierung*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.sortByTitle) {
            sortAntraegeByTitle();
            return true;
        } else if (item.getItemId() == R.id.sortByPriority) {
            sortAntraegeByPrioritaet();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /** Sortierung nach dem Titel*/
    @SuppressLint("NotifyDataSetChanged")
    private void sortAntraegeByTitle() {
        antraege.sort(Comparator.comparing(Antrag::getTitel));
        adapter.notifyDataSetChanged();
    }

    /** Sortierung nach der Priorität*/
    @SuppressLint("NotifyDataSetChanged")
    private void sortAntraegeByPrioritaet() {
        antraege.sort(Comparator.comparingInt(Antrag::getPrioritaet));
        adapter.notifyDataSetChanged();
    }
}
