package com.example.behoerdetogo;

public class Antrag {
    private String titel;
    private String beschreibung;
    private int prioritaet;

    public Antrag(String titel, String beschreibung, int prioritaet) {
        this.titel = titel;
        this.beschreibung = beschreibung;
        this.prioritaet = prioritaet;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public int getPrioritaet() {
        return prioritaet;
    }

    public void setPrioritaet(int prioritaet) {
        this.prioritaet = prioritaet;
    }
}
