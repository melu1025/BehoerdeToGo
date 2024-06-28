package com.example.behoerdetogo;

import android.content.Context;

public class Repository {
    private UserDao userDao;

    public Repository(Context context) {
        BehoerdeDB db = BehoerdeDB.getDatabase(context);
        userDao = db.userDao();
    }

    public boolean insertUser(String email, String password,
                              String geburtsdatum, String vorname, String nachname, String nationalitaet, String geschlecht) {
        User user = new User();
        user.email = email;
        user.password = PasswordUtil.hashPassword(password);
        user.vorname = vorname;
        user.nachname = nachname;
        user.geburtsdatum = geburtsdatum;
        user.nationalitaet = nationalitaet;
        user.geschlecht = geschlecht;

        long result = userDao.insertUser(user);
        return result != -1;
    }

    /** Funktion die überprüft ob Email und passwort Kombination in DB vorhanden ist*/
    public boolean checkUser(String email, String password) {
        User user = userDao.getUserByEmail(email);
        if (user != null) {
            return PasswordUtil.verifyPassword(user.password, password);
        }
        return false;
    }
}
