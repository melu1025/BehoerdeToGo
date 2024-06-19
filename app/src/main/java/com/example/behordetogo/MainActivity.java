package com.example.behordetogo;


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
        antraege.add(new Antrag("Antrag 1", "Personalausweis verlängern", 2));
        antraege.add(new Antrag("Antrag 2", "Wohnort ummelden", 1));
        antraege.add(new Antrag("Antrag 3", "Reisepass anfordern", 3));

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
