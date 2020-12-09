package com.example.thecoffeehouse.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.Model.Product_order;
import com.example.thecoffeehouse.Model.Topping;
import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.ViewHolder.ItemClickListener;
import com.example.thecoffeehouse.ViewHolder.SizeViewHolder;
import com.example.thecoffeehouse.ViewHolder.ToppingViewHolder;

import java.util.ArrayList;

public class ToppingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    ArrayList<Topping> toppingArrayList;
    Context context;

    public ToppingAdapter(ArrayList<Topping> toppingArrayList, Context context) {
        this.toppingArrayList = toppingArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_topping_product,parent,false);
        return new ToppingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ToppingViewHolder toppingViewHolder =(ToppingViewHolder) holder;
        toppingViewHolder.getName().setText(toppingArrayList.get(position).getName());
        toppingViewHolder.getPrice().setText(toppingArrayList.get(position).getPrice());

        toppingViewHolder.setItemClickListener(new ItemClickListener() {
            Topping topping = toppingArrayList.get(position);
            Product_order product_order = ProductAdapter.product_order;
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (!toppingViewHolder.getCheckBox().isChecked() && view!=null){
                    toppingViewHolder.getCheckBox().setChecked(true);
                    product_order.getToppingArrayList().add(topping);
                    ProductAdapter.totalmoney.setText(String.valueOf(product_order.getTotalMoney()));
                }else{
                    toppingViewHolder.getCheckBox().setChecked(false);
                    product_order.getToppingArrayList().remove(topping);
                    ProductAdapter.totalmoney.setText(String.valueOf(product_order.getTotalMoney()));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return toppingArrayList.size();
    }
}
