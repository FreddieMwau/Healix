package com.thinkdev.healix.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.InvoiceTabAdapter;
import com.thinkdev.healix.databinding.ActivityInvoiceDetailsBinding;

public class InvoiceDetails extends AppCompatActivity {


    private ActivityInvoiceDetailsBinding binding;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    InvoiceTabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInvoiceDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tabLayout = findViewById(R.id.invoiceTabLayout);
        viewPager = findViewById(R.id.invoiceViewPager);
        tabAdapter = new InvoiceTabAdapter(this);
        viewPager.setAdapter(tabAdapter);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

    }

    public void onBackIconClicked(View view) {
        onBackPressed();
    }

    public void onInsuranceClicked(View view) {
        Intent i = new Intent(getApplicationContext(), Company.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onEditIconClicked(View view) {
        Toast.makeText(getApplicationContext(), "Edit Invoice clicked", Toast.LENGTH_SHORT).show();
    }

    public void onDeleteIconClicked(View view) {
        Toast.makeText(getApplicationContext(), "Delete Invoice clicked", Toast.LENGTH_SHORT).show();
    }

    public void onAddIconClicked(View view) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.service_bottom_sheet);

        LinearLayout image = dialog.findViewById(R.id.serviceLayout);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add Service Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }
}