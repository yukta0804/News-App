package com.example.newsapp;

import android.view.*;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<News> list;

    public NewsAdapter(List<News> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc, uploadedBy;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.txtTitle);
            desc = view.findViewById(R.id.txtDesc);
            uploadedBy = view.findViewById(R.id.txtUploadedBy);
        }
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        return new ViewHolder(v);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = list.get(position);
        holder.title.setText(news.title);
        holder.desc.setText(news.description);
        holder.uploadedBy.setText("Uploaded by: " + news.uploadedBy);
    }

    public int getItemCount() {
        return list.size();
    }
}
