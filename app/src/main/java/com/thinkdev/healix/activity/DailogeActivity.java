package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivitySignupBinding;
import com.thinkdev.healix.databinding.DialogeInvoicesdetailsBinding;

public class DailogeActivity extends AppCompatActivity {


    private DialogeInvoicesdetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DialogeInvoicesdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }



}