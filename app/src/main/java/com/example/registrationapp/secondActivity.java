package com.example.registrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class secondActivity extends AppCompatActivity {

    private TextView nameText, emailText, phoneText, passwordText;
    private String name,email,phone,password;
    private Button verifyBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findAllViews();
        getUserInput();
        DisplayUserInput();
        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(secondActivity.this, "Your data is successfully verified!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    private void DisplayUserInput() {
        nameText.setText(name);
        emailText.setText(email);
        phoneText.setText(phone);
        passwordText.setText(password);
    }

    private void findAllViews() {
        nameText = findViewById(R.id.name_text);
        emailText = findViewById(R.id.email_text);
        phoneText = findViewById(R.id.phone_text);
        passwordText = findViewById(R.id.password_text);
        verifyBtn = findViewById(R.id.verify_button);
    }

    private void getUserInput() {
        name = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        phone = getIntent().getStringExtra("phone");
        password = getIntent().getStringExtra("password");
    }
}