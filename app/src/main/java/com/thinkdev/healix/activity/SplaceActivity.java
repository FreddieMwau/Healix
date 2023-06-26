package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivitySplashBinding;

public class SplaceActivity extends AppCompatActivity {


    private ActivitySplashBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new Handler().postDelayed(new Runnable() {

// Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(SplaceActivity.this, MainActivity2.class);
//                Intent i = new Intent(SplaceActivity.this, SignInActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 2*1000); // wait for 5 seconds


    }



}