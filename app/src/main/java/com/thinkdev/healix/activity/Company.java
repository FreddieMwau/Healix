package com.thinkdev.healix.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.tabs.TabLayout;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivityCompanyBinding;

import java.util.ArrayList;
import java.util.Objects;

public class Company extends AppCompatActivity {

    private ActivityCompanyBinding binding;
    String[] insurances = {"Sanlam", "Madison", "APA", "Pioneer", "AAR"};
    AutoCompleteTextView companyTextView;
    ArrayAdapter<String> companyAdapter;
    PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompanyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        companyTextView = findViewById(R.id.auto_company_txt);
        pieChart = findViewById(R.id.insurancePieChart);


        companyTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), item + " clicked", Toast.LENGTH_SHORT).show();
            }
        });

        ArrayList<PieEntry> payments = new ArrayList<>();
        payments.add(new PieEntry(760));
        payments.add(new PieEntry(100));
        payments.add(new PieEntry(800));

        PieDataSet pieDataSet = new PieDataSet(payments, "Payments");
        pieDataSet.setDrawValues(false);
        pieChart.getLegend().setEnabled(false);
        pieDataSet.setColors(
                new int[] {
                        ContextCompat.getColor(getApplicationContext(), R.color.light_yellow),
                        ContextCompat.getColor(getApplicationContext(), R.color.light_blue),
                        ContextCompat.getColor(getApplicationContext(), R.color.white)
                }
        );

        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Payment Progress");
        pieChart.setCenterTextColor(R.color.blue);
        pieChart.setCenterTextSize(15f);
        pieChart.animate();
    }

    public void onBackIconClicked(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}