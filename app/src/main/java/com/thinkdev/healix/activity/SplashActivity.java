package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {


    private ActivitySplashBinding binding;
    MotionLayout motionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override

            public void run() {

                Intent i = new Intent(SplashActivity.this, SignInActivity.class);

                startActivity(i);

                // close this activity

                finish();

            }

        }, 4*1000); // wait for 5 seconds


    }



}