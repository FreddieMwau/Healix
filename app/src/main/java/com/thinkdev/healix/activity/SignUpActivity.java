package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class SignUpActivity extends AppCompatActivity {


    private ActivitySignupBinding binding;
    EditText fullName, email, id, phoneNo, password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fullName = findViewById(R.id.fullSignUpNameEdittext);
        email = findViewById(R.id.emailSignUpEdittext);
        id = findViewById(R.id.idNolSignUpEdittext);
        phoneNo = findViewById(R.id.phoneSignUpEdittext);
        password = findViewById(R.id.passSignUpEdittext);
        submit = findViewById(R.id.submitSignUpBtn);
    }
    public void onclick(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "Signed Up successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));

        Intent i = new Intent(SignUpActivity.this, OtpActivity.class);

        startActivity(i);
    }


}