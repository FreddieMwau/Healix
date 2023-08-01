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
import com.thinkdev.healix.databinding.ActivityNewservicesBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class NewServicesActivity extends AppCompatActivity {


    private ActivityNewservicesBinding binding;
    EditText member, client, procedure, clientNumber, charge;
    AutoCompleteTextView genderType;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewservicesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        member = findViewById(R.id.memberEdittext);
        client = findViewById(R.id.clientEdittext);
        procedure = findViewById(R.id.procedureEdittext);
        clientNumber = findViewById(R.id.clientPhoneEdittext);
        genderType = findViewById(R.id.gender_type_edit_text);
        charge = findViewById(R.id.chargeEdittext);
        submit = findViewById(R.id.serviceSubmitBtn);

        String[] genders = {"Male", "Female"};
        ArrayAdapter<String> genderAdapter;

        genderAdapter = new ArrayAdapter<>(this, R.layout.insurance_list, genders);
        genderType.setThreshold(2);
        genderType.setAdapter(genderAdapter);

    }
    public void onclick(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "Service saved successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));

        Intent i = new Intent(NewServicesActivity.this, InvoiceDetails.class);

        startActivity(i);
    }



}

