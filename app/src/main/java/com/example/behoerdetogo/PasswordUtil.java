package com.example.behoerdetogo;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtil {

    private static final int COST = 12;

    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(COST, password.toCharArray());
    }

    public static boolean verifyPassword(String hashedPassword, String password) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), hashedPassword);
        return result.verified;
    }
}
