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
import com.thinkdev.healix.databinding.ActivityNewinvoiceBinding;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class NewInvoiceActivity extends AppCompatActivity {


    private ActivityNewinvoiceBinding binding;
    EditText hospital, insurance, claimForm, preAuthorization;
    AutoCompleteTextView patientType;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewinvoiceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        hospital = findViewById(R.id.hospitalEdittext);
        insurance = findViewById(R.id.insuranceCompanyEdittext);
        patientType = findViewById(R.id.patient_type_edit_text);
        claimForm = findViewById(R.id.claimFormEdittext);
        preAuthorization = findViewById(R.id.preAuthorizationEdittext);
        submit = findViewById(R.id.invoiceSubmitBtn);

        String[] patientTypeList = {"In Patient", "Out Patient"};
        ArrayAdapter<String> patientAdapter;

        patientAdapter = new ArrayAdapter<>(this, R.layout.insurance_list, patientTypeList);
        patientType.setAdapter(patientAdapter);
    }
    public void onclick(View view) {
        MotionToast.Companion.darkToast(this,
                "Success",
                "New Invoice saved successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helvetica_regular));

        Intent i = new Intent(NewInvoiceActivity.this, InvoiceDetails.class);

        startActivity(i);
    }



}