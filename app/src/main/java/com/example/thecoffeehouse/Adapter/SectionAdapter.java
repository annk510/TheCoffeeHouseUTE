package com.example.thecoffeehouse.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Model.News;
import com.example.thecoffeehouse.Model.Section;
import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.ViewHolder.SectionViewHolder;

import java.util.ArrayList;

public class SectionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Section> sections;
    Context context;

    public SectionAdapter(ArrayList<Section> sections, Context context) {
        this.sections = sections;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_section_recyclerview,parent,false);
        return new SectionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SectionViewHolder sectionViewHolder =(SectionViewHolder) holder;
        sectionViewHolder.getTitle().setText(sections.get(position).getHeaderTitle());
        ArrayList list = sections.get(position).getListContent();
        if (list.get(0) instanceof News){
            NewsAdapter newsAdapter = new NewsAdapter(sections.get(position).getListContent(),context);
            sectionViewHolder.getContent().setHasFixedSize(true);
            sectionViewHolder.getContent().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
            sectionViewHolder.getContent().setAdapter(newsAdapter);
        }

    }
    @Override
    public int getItemCount() {
        return sections.size();
    }
}
