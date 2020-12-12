package com.example.thecoffeehouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.thecoffeehouse.View.Fragment_news;
import com.example.thecoffeehouse.View.Fragment_order;
import com.example.thecoffeehouse.View.Fragment_user;
import com.example.thecoffeehouse.View.Row_data_news_product;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Context context;
    public static BottomNavigationView bottomNav;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_news()).commit();
        }
        context = this;

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new Fragment_news();
                            break;
                        case R.id.nav_order:
                            selectedFragment = new Fragment_order();
                            break;
                        case R.id.nav_store:
                            Intent intent = new Intent(context, MapsActivity.class);
                            startActivity(intent);
                            break;
                        case R.id.nav_user:
                            selectedFragment = new Fragment_user();
                            break;
                    }
                    try {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                selectedFragment).commit();
                    }catch (Exception e){

                    }
                    return true;
                }
            };
}