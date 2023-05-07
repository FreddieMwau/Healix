package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.thinkdev.healix.adapter.AddservicesAdapter;
import com.thinkdev.healix.databinding.FragmentInvoicesdetailsBinding;
import com.thinkdev.healix.model.AddServicesData;

import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailsActivity extends AppCompatActivity {

    private List<AddServicesData> data =  new ArrayList<>();
    private FragmentInvoicesdetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentInvoicesdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        data.clear();
        data.add(new AddServicesData("Consultation",
                "Jane Doe","Ksh 1,500"));



        data.add(new AddServicesData("Root Canal",
                "Jane Doe","Ksh 3,500"));


        AddservicesAdapter adapter = new AddservicesAdapter(this,data);
        binding.rcyservices.setHasFixedSize(true);
        binding.rcyservices.setLayoutManager(new LinearLayoutManager(this));
        binding.rcyservices.setAdapter(adapter);

    }
    public void onclick(View view) {

        Intent i = new Intent(InvoiceDetailsActivity.this, NewServicesActivity.class);

        startActivity(i);
    }



}
