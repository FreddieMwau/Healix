package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityForgotBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class ForgotActivity extends AppCompatActivity {


    private ActivityForgotBinding binding;
    EditText email, phoneNo;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityForgotBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = findViewById(R.id.forgotEmailEdittext);
        phoneNo = findViewById(R.id.forgotPhoneNoEdittext);
        submit = findViewById(R.id.forgotSubmitBtn);
    }

    public void onForgotBtnClicked(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "Password reset successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));
        Intent i = new Intent(getApplicationContext(), SignInActivity.class);
        startActivity(i);
    }
}