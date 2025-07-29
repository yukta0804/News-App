package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button viewNews, createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewNews = findViewById(R.id.btnViewNews);
        createAccount = findViewById(R.id.btnCreateAccount);

        viewNews.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, ViewNewsActivity.class));
        });

        createAccount.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });
    }
}
