package com.example.thecoffeehouse.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thecoffeehouse.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Item_order_popular#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Item_order_popular extends Fragment {
    GridView gridView;
    String[] fruitTitle  = {"Sôcôla Lúa Mạch Nóng","Trà sữa Mắc Ca Trân Châu Trắng","Cà Phê Lúa Mạch Đá","Cà Phê Sữa Đá"};
    String[] fruitPrice = {"69.000","45.000","25.000","35.000"};
    int[] fruitImage={R.drawable.mon1,R.drawable.mon2,R.drawable.mon3,R.drawable.mon4};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Item_order_popular() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Item_order_popular.
     */
    // TODO: Rename and change types and number of parameters
    public static Item_order_popular newInstance(String param1, String param2) {
        Item_order_popular fragment = new Item_order_popular();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_item_order_popular, container, false);

        gridView = v.findViewById(R.id.gridview_popular);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        return v;
    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return fruitImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.item_order_popular,null);
            TextView title = view1.findViewById(R.id.title_order_popular);
            TextView price = view1.findViewById(R.id.price_popular);
            ImageView image = view1.findViewById(R.id.img_order_popular);

            title.setText(fruitTitle[position]);
            price.setText(fruitPrice[position]);
            image.setImageResource(fruitImage[position]);
            return  view1;
        }
    }
}