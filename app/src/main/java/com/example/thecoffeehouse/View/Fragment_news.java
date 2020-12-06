package com.example.thecoffeehouse.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Adapter.SectionAdapter;
import com.example.thecoffeehouse.Model.News;
import com.example.thecoffeehouse.Model.Section;
import com.example.thecoffeehouse.R;

import java.util.ArrayList;

public class Fragment_news extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.listofsections);
        ArrayList<Section> sections = new ArrayList<>();
        Section section = new Section();
        section.setHeaderTitle("Ưu đãi đặc biệt");
        ArrayList<News> news = new ArrayList<>();
        news.add(new News(R.drawable.trasua,"Giảm 40%! Amazing goodjobs","Người ta hứa yêu yêu cái đầu buồi","Order ngay"));
        news.add(new News(R.drawable.trasua,"Giảm 40%! Amazing goodjobs","Người ta hứa yêu yêu cái đầu buồi","Order ngay"));
        news.add(new News(R.drawable.trasua,"Giảm 40%! Amazing goodjobs","Người ta hứa yêu yêu cái đầu buồi","Order ngay"));
        section.setListContent(news);
        sections.add(section);
        SectionAdapter sectionAdapter = new SectionAdapter(sections,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(sectionAdapter);

        ImageView accumulatePoints = v.findViewById(R.id.img_news_accumulatePoints);
        accumulatePoints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),News_accumulate_points.class);
                startActivity(intent);
            }
        });

//        ImageView img_order = v.findViewById(R.id.img_news_order);
//        img_order.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent =  new Intent(getActivity(),Fragment_order.class);
//                startActivity(intent);
//            }
//        });
        return v;
    }
}
