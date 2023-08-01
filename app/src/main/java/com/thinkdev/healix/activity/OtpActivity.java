package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.kevinschildhorn.otpview.OTPView;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityOtpBinding;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

public class OtpActivity extends AppCompatActivity {


    private ActivityOtpBinding binding;
    OTPView otpView;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        otpView = findViewById(R.id.otp_view);
        submit = findViewById(R.id.otpSubmitBtn);

    }
    public void onclick(View view) {}


}