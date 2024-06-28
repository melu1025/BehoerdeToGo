package com.example.behoerdetogo;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/** Adapter Klasse für den Recycle Viewer */
public class AntragAdapter extends RecyclerView.Adapter<AntragAdapter.AntragViewHolder> {
    private final List<Antrag> antraege;

    public AntragAdapter(List<Antrag> antraege) {
        this.antraege = antraege;
    }

    /** on Create Methode für das Anzeigen der einzelnen Antraege
     * erstellt so viele die auf den Activity Screen passen*/
    @NonNull
    @Override
    public AntragViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.antrag_item, parent, false);
        return new AntragViewHolder(view);
    }

    /** Funktion die den XML- Elementen Daten zuweißt und
     * On Click Listener für die einzelnen itemViews anlegt*/
    @Override
    public void onBindViewHolder(@NonNull AntragViewHolder holder, int position) {
        Antrag aktuellerAntrag = antraege.get(position);
        holder.titelTextView.setText(aktuellerAntrag.getTitel());
        holder.prioritaetTextView.setText(String.valueOf(aktuellerAntrag.getPrioritaet()));

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AntragDetailActivity.class);
            intent.putExtra("titel", aktuellerAntrag.getTitel());
            intent.putExtra("beschreibung", aktuellerAntrag.getBeschreibung());
            v.getContext().startActivity(intent);
        });
    }

    /** gibt Anzahl an Anträgen zurück */
    @Override
    public int getItemCount() {
        return antraege.size();
    }

    public static class AntragViewHolder extends RecyclerView.ViewHolder {
        public TextView titelTextView;
        public TextView prioritaetTextView;

        public AntragViewHolder(@NonNull View itemView) {
            super(itemView);
            titelTextView = itemView.findViewById(R.id.titelTextView);
            prioritaetTextView = itemView.findViewById(R.id.prioritaetTextView);
        }
    }
}
