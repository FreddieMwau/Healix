package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivityOtpBinding;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

public class OtpActivity extends AppCompatActivity {


    private ActivityOtpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

//        Intent i = new Intent(OtpActivity.this, ProfileActivity.class);

//        startActivity(i);
    }


}