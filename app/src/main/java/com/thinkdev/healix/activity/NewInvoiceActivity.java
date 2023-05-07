package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityNewinvoiceBinding;

public class NewInvoiceActivity extends AppCompatActivity {


    private ActivityNewinvoiceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewinvoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

        Intent i = new Intent(NewInvoiceActivity.this, InvoiceDetailsActivity.class);

        startActivity(i);
    }



}