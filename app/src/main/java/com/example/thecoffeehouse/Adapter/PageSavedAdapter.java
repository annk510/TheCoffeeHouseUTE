package com.example.thecoffeehouse.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.example.thecoffeehouse.View.Item_order_drink;
import com.example.thecoffeehouse.View.Item_order_popular;
import com.example.thecoffeehouse.View.Item_order_food;

public class PageSavedAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;
    String title[]={"Phổ biến","Thức uống","Đồ ăn"};
    public PageSavedAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs=numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Item_order_popular();
            case 1:
                return new Item_order_drink();
            case 2:
                return new Item_order_food();
                default:
                return null;
        }
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
