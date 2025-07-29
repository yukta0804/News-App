package com.example.newsapp;

public class News {
    public String title, description, uploadedBy;

    public News() {} // Firebase requires empty constructor

    public News(String title, String description, String uploadedBy) {
        this.title = title;
        this.description = description;
        this.uploadedBy = uploadedBy;
    }
}
