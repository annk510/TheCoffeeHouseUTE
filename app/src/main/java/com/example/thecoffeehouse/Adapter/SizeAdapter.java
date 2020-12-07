package com.example.thecoffeehouse.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Model.Size;
import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.ViewHolder.ItemClickListener;
import com.example.thecoffeehouse.ViewHolder.SectionViewHolder;
import com.example.thecoffeehouse.ViewHolder.SizeViewHolder;

import java.util.ArrayList;

public class SizeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Size> sizeArrayList;
    Context context;
    private int lastCheckedPosition = -1;

    public SizeAdapter(ArrayList<Size> sizeArrayList, Context context) {
        this.sizeArrayList = sizeArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_size_product,parent,false);
        return new SizeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SizeViewHolder sizeViewHolder =(SizeViewHolder) holder;
        sizeViewHolder.getSize().setText(sizeArrayList.get(position).getName());
        sizeViewHolder.getPrice().setText(sizeArrayList.get(position).getPrice());
        sizeViewHolder.getRadioButton().setChecked(position == lastCheckedPosition);
        sizeViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                lastCheckedPosition = sizeViewHolder.getAdapterPosition();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return sizeArrayList.size();
    }
}
