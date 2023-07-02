package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityNewservicesBinding;

public class NewServicesActivity extends AppCompatActivity {


    private ActivityNewservicesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewservicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {
        Intent i = new Intent(NewServicesActivity.this, InvoiceDetails.class);

        startActivity(i);
    }



}

