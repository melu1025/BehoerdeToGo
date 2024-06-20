package com.example.behoerdetogo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "test.db";
    private static final String TABLE_NAME = "user";
    private static final String COL_2 = "EMAIL";
    private static final String COL_3 = "PASSWORD";
    private static final String COL_4 = "Vorname";
    private static final String COL_5 = "Nachname";
    private static final String COL_6 = "Geburtsdatum";
    private static final String COL_7 = "Nationalitaet";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + "ID INTEGER PRIMARY KEY AUTOINCREMENT, EMAIL TEXT, PASSWORD TEXT , VORNAME TEXT , NACHNAME TEXT , GEBURTSDATUM TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertUser(String email, String password,
                              String geburtsdatum,String vorname,String nachname, String nationalitaet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, email);
        contentValues.put(COL_3, password);
        contentValues.put(COL_4, vorname);
        contentValues.put(COL_5, nachname);
        contentValues.put(COL_6, geburtsdatum);
        contentValues.put(COL_7, nationalitaet);

        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    public boolean checkUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        try (Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL=? AND PASSWORD=?",
                new String[]{email, password})) {
            if (cursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }
}
