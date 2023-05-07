package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.thinkdev.healix.databinding.ActivitySigninBinding;

public class SignInActivity extends AppCompatActivity {


    private ActivitySigninBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
    public void onclick(View view) {

        Intent i = new Intent(SignInActivity.this, MainActivity2.class);

        startActivity(i);
    }
 public void onclicksignup(View view) {

        Intent i = new Intent(SignInActivity.this, SignUpActivity.class);

        startActivity(i);
    }

    public void onclickforgot(View view) {

        Intent i = new Intent(SignInActivity.this, ForgotActivity.class);

        startActivity(i);
    }


}