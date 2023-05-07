package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivitySignupBinding;

public class SignUpActivity extends AppCompatActivity {


    private ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

        Intent i = new Intent(SignUpActivity.this, OtpActivity.class);

        startActivity(i);
    }


}