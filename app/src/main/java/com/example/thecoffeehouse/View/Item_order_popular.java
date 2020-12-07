package com.example.thecoffeehouse.View;

import android.app.Dialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thecoffeehouse.Adapter.ProductAdapter;
import com.example.thecoffeehouse.Model.Product;
import com.example.thecoffeehouse.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Item_order_popular#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Item_order_popular extends Fragment {
    GridView gridView;
    ArrayList<Product> productArrayList;

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

        productArrayList = new ArrayList<Product>();

        Product product1 = new Product();
        product1.setName("Sôcôla Lúa Mạch Nóng");
        product1.setPrice("69.000");
        product1.setImg(R.drawable.mon1);
        productArrayList.add(product1);

        Product product2 = new Product();
        product2.setName("Trà sữa Mắc Ca Trân Châu Trắng");
        product2.setPrice("70.000");
        product2.setImg(R.drawable.mon2);
        productArrayList.add(product2);

        Product product3 = new Product();
        product3.setName("Cà Phê Lúa Mạch Đá");
        product3.setPrice("71.000");
        product3.setImg(R.drawable.mon3);
        productArrayList.add(product3);

        Product product4 = new Product();
        product4.setName("Cà Phê Sữa Đá");
        product4.setPrice("72.000");
        product4.setImg(R.drawable.mon4);
        productArrayList.add(product4);
        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);
        productArrayList.add(product1);
        productArrayList.add(product2);
        productArrayList.add(product3);
        productArrayList.add(product4);

        RecyclerView recyclerView = v.findViewById(R.id.gridview_popular);
        ProductAdapter productAdapter = new ProductAdapter(productArrayList,getActivity());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setAdapter(productAdapter);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return v;
    }

}