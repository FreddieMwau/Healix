package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import com.thinkdev.healix.fragment.HomeFragment;
import com.thinkdev.healix.fragment.InvoicesFragment;
import com.thinkdev.healix.fragment.NotificationFragment;
import com.thinkdev.healix.fragment.ProfileDetailsragment;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityMain2Binding;


public class MainActivity2 extends AppCompatActivity {


    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HomeFragment homeFragment = new HomeFragment();
       NotificationFragment notificationFragment = new NotificationFragment();
       InvoicesFragment invoicesFragment = new InvoicesFragment();
       ProfileDetailsragment profileDetailsragment = new ProfileDetailsragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();



        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,profileDetailsragment).commit();
                        return true;
                    case R.id.navigation_notifications:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,notificationFragment).commit();
                        return true;

                    case R.id.navigation_graph:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,invoicesFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }

    public void onclick(View view) {

        Intent i = new Intent(MainActivity2.this, NewInvoiceActivity.class);

        startActivity(i);
    }


}