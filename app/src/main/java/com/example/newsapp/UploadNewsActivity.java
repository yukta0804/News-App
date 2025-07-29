package com.example.newsapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.auth.FirebaseAuth;

public class UploadNewsActivity extends AppCompatActivity {
    EditText title, desc;
    Button uploadBtn;
    FirebaseAuth auth;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_news);

        title = findViewById(R.id.title);
        desc = findViewById(R.id.description);
        uploadBtn = findViewById(R.id.btnUpload);
        auth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        uploadBtn.setOnClickListener(v -> {
            String userEmail = auth.getCurrentUser().getEmail();
            String key = db.getReference("news").push().getKey();

            db.getReference("news").child(key).setValue(new News(
                    title.getText().toString(), desc.getText().toString(), userEmail
            )).addOnSuccessListener(unused -> {
                Toast.makeText(this, "News Uploaded", Toast.LENGTH_SHORT).show();
                title.setText(""); desc.setText("");
            });
        });
    }
}
