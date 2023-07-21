package com.newsapp.APIs;

import com.newsapp.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("v2/everything")
    Call<NewsModel> getNews(
            @Query("q") String q,
            @Query("from") String from,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );
}