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

import com.example.thecoffeehouse.MainActivity;
import com.example.thecoffeehouse.Model.Product_order;
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
    public static Dialog productdetails301;
    public static TextView totalmoney;
    public static Product_order product_order;


    SizeAdapter sizeAdapter;
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
                productdetails301 = new Dialog(context);
                productdetails301.setContentView(R.layout.dialog_product_detail);
                TextView name = productdetails301.findViewById(R.id.nameofproduct);
                TextView price = productdetails301.findViewById(R.id.priceofproduct);
                ImageView image = productdetails301.findViewById(R.id.imageofproduct);
                TextView description =productdetails301.findViewById(R.id.descripton);
                totalmoney = productdetails301.findViewById(R.id.totalmoney);
                TextView numberofproduct = productdetails301.findViewById(R.id.numberofproduct);
                name.setText(product.getName());
                price.setText(product.getPrice());
                image.setImageResource(product.getImg());
                totalmoney.setText(product.getPrice());
                description.setText(product.getDescription());
                int priceofproduct =Integer.parseInt(product.getPrice()) ;

                product_order = new Product_order();
                product_order.setPrice(priceofproduct);
                product_order.setQuantity(Integer.parseInt((String) numberofproduct.getText()));
                product_order.setPriceofsize(0);
                product_order.setToppingArrayList(new ArrayList<Topping>());

                if (product.getSize().isEmpty()){
                    productdetails301.findViewById(R.id.Size).setVisibility(View.GONE);
                }
                RecyclerView listsize = productdetails301.findViewById(R.id.list_size_product);
                sizeAdapter = new SizeAdapter(product.getSize(),context);
                LinearLayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listsize.setLayoutManager(layoutManager);
                listsize.setAdapter(sizeAdapter);

                listsize.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                if (product.getTopping().isEmpty()){
                    productdetails301.findViewById(R.id.Topping).setVisibility(View.GONE);
                }
                RecyclerView listtopping = productdetails301.findViewById(R.id.list_topping_product);
                ToppingAdapter toppingAdapter = new ToppingAdapter(product.getTopping(),context);
                listtopping.setAdapter(toppingAdapter);
                LinearLayoutManager layoutManager1 = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
                listtopping.setLayoutManager(layoutManager1);
                listtopping.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });

                productdetails301.findViewById(R.id.tru1_301).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(product_order.getQuantity()>1){
                            product_order.setQuantity(product_order.getQuantity()-1);
                        }
                        totalmoney.setText(String.valueOf(product_order.getTotalMoney()));
                        TextView numberofproduct = productdetails301.findViewById(R.id.numberofproduct);
                        numberofproduct.setText(String.valueOf(product_order.getQuantity()) );
                        if (product_order.getQuantity()==1){
                            productdetails301.findViewById(R.id.tru1_301).setClickable(false);
                        }
                    }
                });
                productdetails301.findViewById(R.id.cong1_301).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        product_order.setQuantity(product_order.getQuantity()+1);
                        totalmoney.setText(String.valueOf(product_order.getTotalMoney()));
                        TextView numberofproduct = productdetails301.findViewById(R.id.numberofproduct);
                        numberofproduct.setText(String.valueOf(product_order.getQuantity()) );
                        if (product_order.getQuantity()>1){
                            productdetails301.findViewById(R.id.tru1_301).setClickable(true);
                        }
                    }
                });
                productdetails301.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
}
