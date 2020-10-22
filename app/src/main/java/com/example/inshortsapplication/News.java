package com.example.inshortsapplication;

public class News {

    private String ImageUrl;
    private String title;
    private String description;
    private String content;

    public News(String imageUrl, String title, String description, String content) {
        ImageUrl = imageUrl;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }
}
