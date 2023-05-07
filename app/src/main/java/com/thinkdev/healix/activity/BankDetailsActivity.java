package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityBankdetailsBinding;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

public class BankDetailsActivity extends AppCompatActivity {


    private ActivityBankdetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBankdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

        Intent i = new Intent(BankDetailsActivity.this, MainActivity2.class);

        startActivity(i);
    }


}