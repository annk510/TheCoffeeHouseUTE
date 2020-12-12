package com.example.thecoffeehouse.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thecoffeehouse.Model.News;
import com.example.thecoffeehouse.R;

public class Row_data_news_product extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_data_news_product);
        News news = (News) getIntent().getSerializableExtra("News");
        TextView title = findViewById(R.id.title);
        title.setText(news.getTitle());
        TextView content = findViewById(R.id.content);
        content.setText(news.getDescription());
        TextView conten1t = findViewById(R.id.title_product);
        conten1t.setText(news.getTitle());
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageResource(news.getImage());
    }
}