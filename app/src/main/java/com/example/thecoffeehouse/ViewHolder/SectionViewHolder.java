package com.example.thecoffeehouse.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.R;

public class SectionViewHolder extends RecyclerView.ViewHolder{
    private TextView title;
    private RecyclerView content;

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public RecyclerView getContent() {
        return content;
    }

    public void setContent(RecyclerView content) {
        this.content = content;
    }

    public SectionViewHolder(@NonNull View itemView) {
        super(itemView);
        this.setTitle((TextView) itemView.findViewById(R.id.titleofsection));
        this.setContent((RecyclerView) itemView.findViewById(R.id.contentofsection));
    }
}
