package com.example.inshortsapplication;

public class News {

   private String title;
   private String description;
   private String url;
   private String urlToImage;
   private String content;
   News(String title,String description,String url,String urlToImage,String content){
       this.title  = description;
       this.description = description;
       this.url = url;
       this.urlToImage = urlToImage;
       this.content = content;
   }
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
    public String getContent() {
        return content;
    }
}
