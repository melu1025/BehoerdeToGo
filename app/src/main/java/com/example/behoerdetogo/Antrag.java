package com.example.behoerdetogo;

public class Antrag {
    private final String titel;
    private final String beschreibung;
    private final int prioritaet;

    public Antrag(String titel, String beschreibung, int prioritaet) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.prioritaet = prioritaet;
    }

    public String getTitel() {
        return titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public int getPrioritaet() {
        return prioritaet;
    }

}
