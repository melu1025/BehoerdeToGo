package com.example.behoerdetogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/** SQL-Light Database Klasse */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "behoerde.db";
    private static final String TABLE_NAME = "user";
    private static final String COL_2 = "EMAIL";
    private static final String COL_3 = "PASSWORD";
    private static final String COL_4 = "Vorname";
    private static final String COL_5 = "Nachname";
    private static final String COL_6 = "Geburtsdatum";
    private static final String COL_7 = "Nationalitaet";
    private static final String COL_8 = "Geschlecht";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /** on Create Methode für die DB
     * erstllt User Tabelle in DB*/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "EMAIL TEXT, " +
                "PASSWORD TEXT, " +
                "VORNAME TEXT, " +
                "NACHNAME TEXT, " +
                "GEBURTSDATUM TEXT, " +
                "NATIONALITAET TEXT, " +
                "GESCHLECHT TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /** Methode zum schreiben eines Nutzers in die DB*/
    public boolean insertUser(String email, String password,
                              String geburtsdatum, String vorname, String nachname, String nationalitaet, String geschlecht) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, PasswordUtil.hashPassword(password));
        contentValues.put(COL_4, vorname);
        contentValues.put(COL_5, nachname);
        contentValues.put(COL_6, geburtsdatum);
        contentValues.put(COL_7, nationalitaet);
        contentValues.put(COL_8, geschlecht);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    /** Funktion die überprüft ob Email und passwort Kombination in DB vorhanden ist*/
    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        try (Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL=?",
                new String[]{email})) {
            if (cursor.moveToFirst()) {
                String storedHash = cursor.getString(cursor.getColumnIndexOrThrow(COL_3));
                return PasswordUtil.verifyPassword(storedHash, password);
            }
        }
        return false;
    }
}

