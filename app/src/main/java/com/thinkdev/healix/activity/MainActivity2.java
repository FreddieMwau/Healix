package com.thinkdev.healix.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityMain2Binding;
import com.thinkdev.healix.fragment.HomeFragment;
import com.thinkdev.healix.fragment.AnalyticsFragment;
import com.thinkdev.healix.fragment.LibraryFragment;


public class MainActivity2 extends AppCompatActivity {


    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        HomeFragment homeFragment = new HomeFragment();
       AnalyticsFragment analyticsFragment = new AnalyticsFragment();
       LibraryFragment libraryFragment = new LibraryFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();



        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.navigation_profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, libraryFragment).commit();
                        return true;
                    case R.id.navigation_graph:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, analyticsFragment).commit();
                        return true;
                }

                return false;
            }
        });
    }
}