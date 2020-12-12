package com.example.thecoffeehouse.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.R;

public class NewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    private ImageView img;
    private TextView title,description;
    private TextView action;
    private ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ImageView getImg() {
        return img;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public TextView getAction() {
        return action;
    }

    public void setAction(TextView action) {
        this.action = action;
    }

    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        this.setImg((ImageView) itemView.findViewById(R.id.imgofnews));
        this.setTitle((TextView) itemView.findViewById(R.id.titleofnews));
        this.setDescription((TextView) itemView.findViewById(R.id.desofnews));
        this.setAction((TextView) itemView.findViewById(R.id.actionofnews));
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),false);
    }

    @Override
    public boolean onLongClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition(),true);
        return true;
    }
}
