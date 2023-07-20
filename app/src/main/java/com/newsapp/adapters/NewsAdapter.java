package com.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.newsapp.NewsDetailsActivity;
import com.newsapp.R;
import com.newsapp.databinding.NewsItemBinding;
import com.newsapp.models.NewsModel;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    public List<NewsModel.Article> psy;
    public Context context;

    public NewsAdapter(List<NewsModel.Article> list, Context context) {
        this.psy = list;
        this.context = context;
    }

    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsAdapter.MyViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }

    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder holder, final int position) {
        holder.b.tvTitle.setText(psy.get(position).title);
       /* holder.b.blogContent.setText(psy.get(position).content);
        Glide.with(context).load("https://happyu.co.in/storage/blog/upload/"+psy.get(position).image).into(holder.b.ivImage);*/
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, NewsDetailsActivity.class);
                intent.putExtra("newsModel", new Gson().toJson(psy.get(position)));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.psy.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private NewsItemBinding b;

        public MyViewHolder(NewsItemBinding b) {
            super(b.getRoot());
            this.b = b;
        }
    }
}





