package com.example.behoerdetogo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/** Klasse für die LoginActivity */
public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private Repository db;

    /** on create Methode für die Login Klasse
     * Variablen werden Elementen in der XML Datei zugewiesesn
     * und onClickListener werden gesestz */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        db = new Repository(this);

        loginButton.setOnClickListener(v -> loginUser());

        registerButton.setOnClickListener(v -> startActivity(
                new Intent(LoginActivity.this, RegistrationActivity.class)));
    }

    /** Methode die Beim Clicken des Login Buttons aufgerufen wird
     * Überprüft ob Email und Passwort Kombination in der DB vorhanden ist */
    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this,
                    "Bitte alle Felder ausfüllen", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isUserExists = db.checkUser(email, password);
        if (isUserExists) {
            Toast.makeText(LoginActivity.this,
                    "Anmeldung erfolgreich", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
            finish();
        } else {
            Toast.makeText(LoginActivity.this,
                    "Anmeldung fehlgeschlagen: " +
                            "Bitte überprüfen Sie Ihre Anmeldedaten", Toast.LENGTH_SHORT).show();
        }
    }
}
