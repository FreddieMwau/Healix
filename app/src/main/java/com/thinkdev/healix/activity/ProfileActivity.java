package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityProfileBinding;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

public class ProfileActivity extends AppCompatActivity {


    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

        Intent i = new Intent(ProfileActivity.this, BankDetailsActivity.class);

        startActivity(i);
    }


}