package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    Button loginBtn;
    TextView registerLink;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.btnLogin);
        registerLink = findViewById(R.id.txtRegister);
        auth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(v -> {
            auth.signInWithEmailAndPassword(
                    email.getText().toString(), password.getText().toString()
            ).addOnSuccessListener(authResult -> {
                startActivity(new Intent(LoginActivity.this, UploadNewsActivity.class));
                finish();
            }).addOnFailureListener(e -> {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            });
        });

        registerLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}
