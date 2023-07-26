package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.FragmentPaymentHistoryBinding;

import java.util.ArrayList;

public class PaymentHistoryFragment extends Fragment {

    private FragmentPaymentHistoryBinding paymentHistoryBinding;
    BarChart barChart;
    RadioGroup historyRadioGroupBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        paymentHistoryBinding = FragmentPaymentHistoryBinding.inflate(inflater, container, false);
        return paymentHistoryBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barChart = view.findViewById(R.id.payment_history_bar_chart);
        historyRadioGroupBtn = view.findViewById(R.id.paymentHistoryRadioGroupBtn);
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        final int checkedColor = ContextCompat.getColor(requireContext() ,R.color.white);
        final int uncheckedColor = ContextCompat.getColor(requireContext(), R.color.blue);

        for (int i = 1; i<=12; i++){
            float value = (float) (i*10.0);
            BarEntry barEntry = new BarEntry(i, value);
            barEntries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Weekly Payments");
        barDataSet.setColors(
                ContextCompat.getColor(getContext(), R.color.light_blue),
                ContextCompat.getColor(getContext(), R.color.light_yellow));
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(5000);
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);

        historyRadioGroupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i = 0; i < count; i++){
                    RadioButton button = (RadioButton) group.getChildAt(i);
                    if (button.getId() == checkedId) {
                        button.setTextColor(checkedColor);
                    } else {
                        button.setTextColor(uncheckedColor);
                    }
                }
            }
        });

    }
}