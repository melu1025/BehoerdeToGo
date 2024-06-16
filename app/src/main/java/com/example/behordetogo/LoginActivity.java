package com.example.behordetogo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        Button registerButton = findViewById(R.id.registerButton);
        db = new DatabaseHelper(this);

        loginButton.setOnClickListener(v -> loginUser());

        registerButton.setOnClickListener(v -> startActivity(
                new Intent(LoginActivity.this, RegistrationActivity.class)));
    }

    private void loginUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this,
                    "Bitte alle Felderausfüllen", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isUserExists = db.checkUser(email, password);
        if (isUserExists) {
            Toast.makeText(LoginActivity.this,
                    "Anmeldung erfolgreich", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
        } else {
            Toast.makeText(LoginActivity.this,
                    "Anmeldung fehlgeschlagen: " +
                            "Bitte überprüfen sie ihre Anmeldedaten", Toast.LENGTH_SHORT).show();
        }
    }
}
