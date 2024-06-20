package com.example.behoerdetogo;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Antrag> antraege;
    private AntragAdapter adapter;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.sortByTitle) {
            sortAntraegeByTitle();
            return true;
        } else if (item.getItemId() == R.id.sortByPriority) {
            sortAntraegeByPrioritaet();
            return true;
        }
        // Handle other menu items if any
        return super.onOptionsItemSelected(item);
    }

    private void sortAntraegeByTitle() {
        Collections.sort(antraege, new Comparator<Antrag>() {
            @Override
            public int compare(Antrag a1, Antrag a2) {
                return a1.getTitel().compareTo(a2.getTitel());
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void sortAntraegeByPrioritaet() {
        Collections.sort(antraege, new Comparator<Antrag>() {
            @Override
            public int compare(Antrag a1, Antrag a2) {
                return Integer.compare(a1.getPrioritaet(), a2.getPrioritaet());
            }
        });
        adapter.notifyDataSetChanged();
    }
}
