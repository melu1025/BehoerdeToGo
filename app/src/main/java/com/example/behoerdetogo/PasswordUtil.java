package com.example.behoerdetogo;

import at.favre.lib.crypto.bcrypt.BCrypt;

/** Klasse für die Verschlüsselung mit BCrypt */
public class PasswordUtil {

    private static final int COST = 12;

    /** Methode zum Haschen des Passworts */
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(COST, password.toCharArray());
    }

    /** Methode zur Verifizierung das Hash und Passwort übereinstimmen */
    public static boolean verifyPassword(String hashedPassword, String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }
}
