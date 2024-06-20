package com.example.behoerdetogo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, vornameEditText, nachnameEditText, geburtsdatumEditText, nationalitaetEditText;
    private DatabaseHelper db;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        vornameEditText = findViewById(R.id.vornameEditText);
        nachnameEditText = findViewById(R.id.nachnameEditText);
        geburtsdatumEditText = findViewById(R.id.geburtsdatumEditText);
        nationalitaetEditText = findViewById(R.id.nationalitaetEditText);
        Button registerButton = findViewById(R.id.registerButton);
        db = new DatabaseHelper(this);

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String vorname = vornameEditText.getText().toString().trim();
        String nachname = nachnameEditText.getText().toString().trim();
        String geburtsdatum = geburtsdatumEditText.getText().toString().trim();
        String nationalitaet = nationalitaetEditText.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Bitte geben sie ihre Benutzerdaten ein", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isInserted = db.insertUser(email, password, vorname, nachname, geburtsdatum, nationalitaet);
        if (isInserted) {
            Toast.makeText(RegistrationActivity.this, "Registrierung Erfolgreich", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(RegistrationActivity.this, "Registrierung Fehlgeschlagen", Toast.LENGTH_SHORT).show();
        }
    }
}