package com.newsapp;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.newsapp.APIs.RetrofitClient;
import com.newsapp.adapters.NewsAdapter;
import com.newsapp.databinding.ActivityNewsHeadlinesBinding;
import com.newsapp.models.NewsModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsHeadlinesActivity extends AppCompatActivity {
    ActivityNewsHeadlinesBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewsHeadlinesBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);

        blogs();
    }

    private void blogs() {
        b.rlLoading.setVisibility(View.VISIBLE);
        Call<NewsModel> call = RetrofitClient.getInstance().getApi().getNews();
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                b.rlLoading.setVisibility(View.GONE);
                Log.e("response", new Gson().toJson(response.body()));
                if (response.isSuccessful()) {
                    int statusCode = response.code();
                    if (statusCode == 200) {

                        NewsAdapter newsAdapter = new NewsAdapter(response.body().articles, NewsHeadlinesActivity.this);
                        b.rvNewsHeadline.setAdapter(newsAdapter);

                    } else {
                        b.rlLoading.setVisibility(View.GONE);
                        Toast.makeText(NewsHeadlinesActivity.this, "something went wrong", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(NewsHeadlinesActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                t.printStackTrace();
                b.rlLoading.setVisibility(View.GONE);
                Toast.makeText(NewsHeadlinesActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}