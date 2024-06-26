package com.example.behoerdetogo;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

public class RegistrationActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText, confirmPasswordEditText, vornameEditText, nachnameEditText, nationalitaetEditText;
    private DatabaseHelper db;
    private RadioGroup radioGeschlechter;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText("Bitte geben sie ihr Geburtsdatum ein");

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        vornameEditText = findViewById(R.id.vornameEditText);
        nachnameEditText = findViewById(R.id.nachnameEditText);
        nationalitaetEditText = findViewById(R.id.nationalitaetEditText);
        radioGeschlechter = findViewById(R.id.radioGeschlechter);
        Button registerButton = findViewById(R.id.registerButton);
        db = new DatabaseHelper(this);

        registerButton.setOnClickListener(v -> registerUser());
    }

    private void registerUser() {
        int checkId = radioGeschlechter.getCheckedRadioButtonId();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();
        String vorname = vornameEditText.getText().toString().trim();
        String nachname = nachnameEditText.getText().toString().trim();
        String geburtsdatum = dateButton.getText().toString().trim();
        String nationalitaet = nationalitaetEditText.getText().toString().trim();
        RadioButton rb = findViewById(checkId);
        String geschlecht = rb.getText().toString();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegistrationActivity.this, "Bitte geben sie ihre Benutzerdaten ein", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(confirmPassword)) {
            Toast.makeText(RegistrationActivity.this, "Ihre Passwörter stimmen nicht überein", Toast.LENGTH_SHORT).show();
            return;
        }
        if (geburtsdatum.equals("Bitte geben sie ihr Geburtsdatum ein")) {
            Toast.makeText(RegistrationActivity.this, "Bitte geben sie ihr Geburtsdatum ein", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isInserted = db.insertUser(email, password, vorname, nachname, geburtsdatum, nationalitaet, geschlecht);
        if (isInserted) {
            Toast.makeText(RegistrationActivity.this, "Registrierung Erfolgreich", Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(RegistrationActivity.this, "Registrierung Fehlgeschlagen", Toast.LENGTH_SHORT).show();
        }
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            month = month + 1;
            String date = makeDateString(day, month, year);
            dateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);

    }
    private String makeDateString(int day, int month, int year)
    {
        return day + "." + month + "." + year;
    }
    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }
}
