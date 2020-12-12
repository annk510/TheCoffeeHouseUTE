package com.example.thecoffeehouse.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Model.News;
import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.View.Row_data_news_product;
import com.example.thecoffeehouse.ViewHolder.ItemClickListener;
import com.example.thecoffeehouse.ViewHolder.NewViewHolder;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<News> news;
    Context context;

    public NewsAdapter(ArrayList<News> news, Context context) {
        this.news = news;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_news,parent,false);

        return new NewViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewViewHolder viewHolder = (NewViewHolder) holder;
        viewHolder.getImg().setImageResource(news.get(position).getImage());
        viewHolder.getTitle().setText(news.get(position).getTitle());
        viewHolder.getDescription().setText(news.get(position).getDescription());
        viewHolder.getAction().setText(news.get(position).getAction());
        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(context, Row_data_news_product.class);
                intent.putExtra("News",news.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }
}
