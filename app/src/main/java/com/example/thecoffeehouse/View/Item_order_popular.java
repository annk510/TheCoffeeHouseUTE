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
import com.example.thecoffeehouse.Model.Size;
import com.example.thecoffeehouse.Model.Topping;
import com.example.thecoffeehouse.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Item_order_popular#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Item_order_popular extends Fragment {
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
        product1.setPrice("69000");
        product1.setImg(R.drawable.mon1);
        ArrayList<Size> sizes1 = new ArrayList<>();
        sizes1.add(new Size("Nhỏ","0"));
        sizes1.add(new Size("Vừa","5000"));
        sizes1.add(new Size("Lớn","10000"));
        product1.setSize(sizes1);
        ArrayList<Topping> toppings1 = new ArrayList<>();
        toppings1.add(new Topping("Expresso","5000"));
        toppings1.add(new Topping("Sauce Chocolate","10000"));
        product1.setTopping(toppings1);
        product1.setDescription("Tận hưởng từng ngụm ấm áp, ngọt dịu từ chocolate thượng hạng kết" +
                " hợp với lúa mạch thơm lừng. Vị Giáng sinh đặc biệt này là dành cho bạn, thưởng" +
                " thức ngay nhé");
        productArrayList.add(product1);

        Product product2 = new Product();
        product2.setName("Trà sữa Mắc Ca Trân Châu Trắng");
        product2.setPrice("70000");
        product2.setImg(R.drawable.mon2);
        ArrayList<Size> sizes2 = new ArrayList<>();
        sizes2.add(new Size("Nhỏ","0"));
        sizes2.add(new Size("Vừa","5000"));
        product2.setSize(sizes2);
        ArrayList<Topping> toppings2 = new ArrayList<>();
        toppings2.add(new Topping("Expresso","6000"));
        toppings2.add(new Topping("Sauce Chocolate","12000"));
        product2.setTopping(toppings2);
        product2.setDescription("Đổi vị tươi mới - Vừa ngon vừa khỏe. Mỗi ngày với Nhà sẽ " +
                "là điều tươi mới hơn với sữa đặt hạt mắc ca thơm ngon, bổ dưỡng quyện cùng " +
                "nền trà OOlong cho vị cân bằng, ngọt dịu. Trân châu trắng giòn dai được thêm" +
                " sẵn mang lại cho bạn cảm giác đã trong từng ngụm, thỏa mãn cơn thèm trà sữa ngay");
        productArrayList.add(product2);

        Product product3 = new Product();
        product3.setName("Cà Phê Lúa Mạch Đá");
        product3.setPrice("71000");
        product3.setImg(R.drawable.mon3);
        ArrayList<Size> sizes3 = new ArrayList<>();
        product3.setSize(sizes3);
        ArrayList<Topping> toppings3 = new ArrayList<>();
        toppings3.add(new Topping("Expresso","6000"));
        toppings3.add(new Topping("Sauce Chocolate","12000"));
        toppings3.add(new Topping("Sauce ahihi","15000"));
        product3.setTopping(toppings3);
        product3.setDescription("Đắm chìm vào hương vị cà phê mới mẻ khi kết hợp cùng lúa mạch thơm ngon. " +
                "Không quá đắng lại ngọt dịu dễ ghiền. Thưởng thức ngay nhé");
        productArrayList.add(product3);

        Product product4 = new Product();
        product4.setName("Cà Phê Sữa Đá");
        product4.setPrice("72000");
        product4.setSize(sizes1);
        product4.setDescription("Cà phê phin kết hợp cùng sữa đặc là một sáng tạo đầy tự hào của người việt, " +
                "được xem là món uống thương hiệu của Việt Nam");
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