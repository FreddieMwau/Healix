package com.thinkdev.healix.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivitySigninBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class SignInActivity extends AppCompatActivity {


    private ActivitySigninBinding binding;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        email = findViewById(R.id.nameSignInEdittext);
        password = findViewById(R.id.passSignInEdittext);
    }
    public void onclick(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "Logged In successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));

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