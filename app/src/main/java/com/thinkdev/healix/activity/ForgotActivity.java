package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityForgotBinding;

public class ForgotActivity extends AppCompatActivity {


    private ActivityForgotBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onForgotBtnClicked(View view) {
        Intent i = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(i);
    }
}