package com.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.newsapp.databinding.ActivityNewsDetailsBinding;
import com.newsapp.models.NewsModel;

public class NewsDetailsActivity extends AppCompatActivity {
    ActivityNewsDetailsBinding b;
    String model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityNewsDetailsBinding.inflate(getLayoutInflater());
        View view = b.getRoot();
        setContentView(view);
        getNewDetails();
        b.back.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    private void getNewDetails() {
        model = getIntent().getStringExtra("newsModel");
        NewsModel.Article newsArticle = new Gson().fromJson(model, NewsModel.Article.class);
        b.tvTitle.setText(newsArticle.title);
        b.tvAuther.setText(newsArticle.author);
        b.tvContent.setText(newsArticle.content);
        Glide.with(NewsDetailsActivity.this).load(newsArticle.urlToImage).placeholder(R.drawable.placeholder).into(b.ivImage);
    }
}