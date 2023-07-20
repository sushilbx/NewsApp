package com.newsapp.models;

import java.util.Date;
import java.util.List;

public class NewsModel {
    public String status;
    public int totalResults;
    public List<Article> articles;

    public class Article {
        public Source source;
        public String author;
        public String title;
        public String description;
        public String url;
        public String urlToImage;
        public Date publishedAt;
        public String content;
    }

    public class Source {
        public String id;
        public String name;
    }
}
