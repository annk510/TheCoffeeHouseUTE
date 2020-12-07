package com.example.thecoffeehouse.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.thecoffeehouse.ViewHolder.ItemClickListener;
import com.example.thecoffeehouse.Model.Product;
import com.example.thecoffeehouse.Model.Size;
import com.example.thecoffeehouse.Model.Topping;
import com.example.thecoffeehouse.R;
import com.example.thecoffeehouse.ViewHolder.ProductViewHolder;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Product> productArrayList;
    private Context context;


    public ProductAdapter(ArrayList<Product> productArrayList, Context context) {
        this.productArrayList = productArrayList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductViewHolder productViewHolder =(ProductViewHolder) holder;
        Product product = productArrayList.get(position);
        productViewHolder.getName().setText(product.getName());
        productViewHolder.getPrice().setText(product.getPrice());
        productViewHolder.getImage().setImageResource(product.getImg());

        productViewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Dialog productdetailsdialog = new Dialog(context);
                productdetailsdialog.setContentView(R.layout.dialog_product_detail);
                TextView name = productdetailsdialog.findViewById(R.id.nameofproduct);
                TextView price = productdetailsdialog.findViewById(R.id.priceofproduct);
                ImageView image = productdetailsdialog.findViewById(R.id.imageofproduct);
                name.setText(product.getName());
                price.setText(product.getPrice());
                image.setImageResource(product.getImg());
                ArrayList<Size> sizes = new ArrayList<>();
                sizes.add(new Size("Nhỏ",""));
                sizes.add(new Size("Vừa","5000"));
                sizes.add(new Size("Lớn","10000"));
                product.setSize(sizes);
                RecyclerView listsize = productdetailsdialog.findViewById(R.id.list_size_product);
                SizeAdapter sizeAdapter = new SizeAdapter(sizes,context);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listsize.setLayoutManager(layoutManager);
                listsize.setAdapter(sizeAdapter);
                ArrayList<Topping> toppings = new ArrayList<>();
                toppings.add(new Topping("Expresso","5000"));
                toppings.add(new Topping("Sauce Chocolate","10000"));
                product.setTopping(toppings);
                RecyclerView listtopping = productdetailsdialog.findViewById(R.id.list_topping_product);
                ToppingAdapter toppingAdapter = new ToppingAdapter(toppings,context);
                listtopping.setAdapter(toppingAdapter);
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listtopping.setLayoutManager(layoutManager1);
                productdetailsdialog.show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
