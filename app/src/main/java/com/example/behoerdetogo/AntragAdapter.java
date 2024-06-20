package com.example.behoerdetogo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class AntragAdapter extends RecyclerView.Adapter<AntragAdapter.AntragViewHolder> {
    private List<Antrag> antraege;

    public AntragAdapter(List<Antrag> antraege) {
        this.antraege = antraege;
    }

    @NonNull
    @Override
    public AntragViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.antrag_item, parent, false);
        return new AntragViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AntragViewHolder holder, int position) {
        Antrag aktuellerAntrag = antraege.get(position);
        holder.titelTextView.setText(aktuellerAntrag.getTitel());
        holder.beschreibungTextView.setText(aktuellerAntrag.getBeschreibung());
        holder.prioritaetTextView.setText(String.valueOf(aktuellerAntrag.getPrioritaet()));
    }

    @Override
    public int getItemCount() {
        return antraege.size();
    }

    public static class AntragViewHolder extends RecyclerView.ViewHolder {
        public TextView titelTextView;
        public TextView beschreibungTextView;
        public TextView prioritaetTextView;

        public AntragViewHolder(@NonNull View itemView) {
            super(itemView);
            titelTextView = itemView.findViewById(R.id.titelTextView);
            beschreibungTextView = itemView.findViewById(R.id.beschreibungTextView);
            prioritaetTextView = itemView.findViewById(R.id.prioritaetTextView);
        }
    }
}
