package com.example.thecoffeehouse.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.activity_help;
import com.example.thecoffeehouse.activity_order_history;
import com.example.thecoffeehouse.activity_user_information;

public class Fragment_user extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_user, container, false);
        TextView User_information_txt = view.findViewById(R.id.txt_user_information);
        User_information_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_user_information.class);
                startActivity(intent);
            }
        });
        TextView User_help_txt = view.findViewById(R.id.txt_user_help);
        User_help_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_help.class);
                startActivity(intent);
            }
        });
        TextView User_history_txt = view.findViewById(R.id.txt_user_history);
        User_history_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), activity_order_history.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
