package com.example.registrationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText name, email, phone, password;
    private Button registerBtn;
    String nameText,emailText, phoneText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findAllViews();
        registerBtn.setEnabled(false);
        validateNonEmptyInput();
        registerBtn.setOnClickListener(v -> openSecondActivity());
    }

    void findAllViews(){
        name = findViewById(R.id.name_edit_text);
        email = findViewById(R.id.email_edit_text);
        phone = findViewById(R.id.phone_edit_text);
        password = findViewById(R.id.password_edit_text);
        registerBtn = findViewById(R.id.register_button);
    }

    void getUserInput(){
        nameText = name.getText().toString().trim();
        emailText = email.getText().toString().trim();
        phoneText = phone.getText().toString().trim();
        passwordText = password.getText().toString().trim();
    }

    private void validateNonEmptyInput() {

        TextWatcher textWatcher = getTextWatcher();

        name.addTextChangedListener(textWatcher);
        email.addTextChangedListener(textWatcher);
        phone.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);
    }

    @NonNull
    private TextWatcher getTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                getUserInput();
                if (nameText.isEmpty() || emailText.isEmpty()|| phoneText.isEmpty() || passwordText.isEmpty())
                    registerBtn.setEnabled(false);
                else registerBtn.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    void openSecondActivity(){
        Intent intent = new Intent(this, secondActivity.class);
        intent.putExtra("name", nameText);
        intent.putExtra("email", emailText);
        intent.putExtra("phone", phoneText);
        intent.putExtra("password", passwordText);
        startActivity(intent);
    }

}