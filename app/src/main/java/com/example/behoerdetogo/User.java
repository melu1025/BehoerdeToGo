package com.example.behoerdetogo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String email;
    public String password;
    public String vorname;
    public String nachname;
    public String geburtsdatum;
    public String nationalitaet;
    public String geschlecht;
}