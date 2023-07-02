package com.thinkdev.healix.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.FragmentHistoryBinding;
import com.thinkdev.healix.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {


    private FragmentHistoryBinding binding;
    BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        barChart = view.findViewById(R.id.history_bar_chart);
        ArrayList<BarEntry> barEntries = new ArrayList<>();

        for (int i = 1; i<=7; i++){
            float value = (float) (i*10.0);
            BarEntry barEntry = new BarEntry(i, value);
            barEntries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "Weekly Payments");
        barDataSet.setColors(
                new int[]
                        {
                                ContextCompat.getColor(getContext(), R.color.light_blue),
                                ContextCompat.getColor(getContext(), R.color.blue)
                        });
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(5000);
        barChart.getLegend().setEnabled(false);
        barChart.getDescription().setEnabled(false);
        barChart.getAxisRight().setEnabled(false);
    }
}