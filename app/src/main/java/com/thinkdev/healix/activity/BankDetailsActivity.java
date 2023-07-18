package com.thinkdev.healix.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityBankdetailsBinding;
import com.thinkdev.healix.databinding.ActivitySignupBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class BankDetailsActivity extends AppCompatActivity {


    private ActivityBankdetailsBinding binding;
    RadioGroup bankRadioGroupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityBankdetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bankRadioGroupBtn = findViewById(R.id.bankDetailsRadioGroupBtn);

        final int checkedColor = ContextCompat.getColor(getApplicationContext() ,R.color.white);
        final int uncheckedColor = ContextCompat.getColor(getApplicationContext(), R.color.blue);

        bankRadioGroupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i = 0; i < count; i++){
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() == checkedId){
                        Toast.makeText(getApplicationContext(), radioButton.getText() + " clicked", Toast.LENGTH_SHORT).show();
                        radioButton.setTextColor(checkedColor);
                    } else {
                        radioButton.setTextColor(uncheckedColor);
                    }
                }
            }
        });
    }
    public void onclick(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "Bank details saved successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));

        Intent i = new Intent(BankDetailsActivity.this, MainActivity2.class);

        startActivity(i);
    }


}