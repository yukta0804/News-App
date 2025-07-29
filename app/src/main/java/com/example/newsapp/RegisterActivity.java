package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    EditText email, password, confirmPass;
    Button registerBtn;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPass = findViewById(R.id.confirmPassword);
        registerBtn = findViewById(R.id.btnRegister);
        auth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(v -> {
            if (!password.getText().toString().equals(confirmPass.getText().toString())) {
                Toast.makeText(this, "Passwords don't match", Toast.LENGTH_SHORT).show();
                return;
            }

            auth.createUserWithEmailAndPassword(
                    email.getText().toString(), password.getText().toString()
            ).addOnSuccessListener(authResult -> {
                startActivity(new Intent(RegisterActivity.this, UploadNewsActivity.class));
                finish();
            }).addOnFailureListener(e -> {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();
            });
        });
    }
}
