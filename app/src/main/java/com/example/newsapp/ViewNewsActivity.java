package com.example.newsapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;
import com.google.firebase.database.*;
import java.util.*;

public class ViewNewsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<News> newsList = new ArrayList<>();
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        recyclerView = findViewById(R.id.recyclerNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        FirebaseDatabase.getInstance().getReference("news")
                .addValueEventListener(new ValueEventListener() {
                    public void onDataChange(DataSnapshot snapshot) {
                        newsList.clear();
                        for (DataSnapshot snap : snapshot.getChildren()) {
                            newsList.add(snap.getValue(News.class));
                        }
                        adapter.notifyDataSetChanged();
                    }

                    public void onCancelled(DatabaseError error) {}
                });
    }
}
