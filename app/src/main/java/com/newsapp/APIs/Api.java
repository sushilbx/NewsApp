package com.newsapp.APIs;

import com.newsapp.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("v2/everything?q=tesla&from=2023-06-20&sortBy=publishedAt&apiKey=c0aac9e83e4f4f8cb0f4d7ad55fced7d")
    Call<NewsModel> getNews(
    );
}