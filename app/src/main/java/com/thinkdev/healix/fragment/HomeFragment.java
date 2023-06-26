package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentHomeBinding;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TransactionAdapter transactionAdapter;
    RecyclerView transactionRecycler;
    BarChart barChart;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barChart = view.findViewById(R.id.bar_chart);
        ArrayList<BarEntry> barEntries = new ArrayList<>();
        transactionRecycler = view.findViewById(R.id.transactionsRecycler);

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
                        ContextCompat.getColor(getContext(), R.color.light_blue),
                        ContextCompat.getColor(getContext(), R.color.light_blue),
                        ContextCompat.getColor(getContext(), R.color.light_blue),
                        ContextCompat.getColor(getContext(), R.color.light_blue),
                        ContextCompat.getColor(getContext(), R.color.light_blue),
                        ContextCompat.getColor(getContext(), R.color.light_yellow)
                });
        barDataSet.setDrawValues(false);
        barChart.setData(new BarData(barDataSet));
        barChart.animateY(5000);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionAdapter = new TransactionAdapter(TransactionItemList());
        transactionRecycler.setAdapter(transactionAdapter);
        transactionRecycler.setLayoutManager(layoutManager);
    }

    private List<TransactionalModel> TransactionItemList() {
        List<TransactionalModel> transactionalModelList = new ArrayList<>();

        TransactionalModel transactionalModel = new TransactionalModel("25", "Tuesday", "June", "54,000", TransactionChildList());
        transactionalModelList.add(transactionalModel);

        return  transactionalModelList;
    }

    private List<TransactionChildModel> TransactionChildList() {
        List<TransactionChildModel> childModelList = new ArrayList<>();

        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 56, "Sanlam", "Confirmed payment on #INV3672891 of Ksh 34,000", "12:38 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.icea, 34, "ICEA LION", "Confirmed payment on #INV3674324 of Ksh 93,000", "06:19 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.madison, 80, "Madison", "Confirmed payment on #INV3672891 of Ksh 40,000", "09:45 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.aar, 67, "AAR", "Confirmed payment on #INV3672891 of Ksh 76,000", "12:05 PM"));
        childModelList.add(new TransactionChildModel(R.drawable.pioneer, 38, "Pioneer", "Confirmed payment on #INV3672891 of Ksh 29,000", "03:55 PM"));
        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 73, "Sanlam", "Confirmed payment on #INV3672891 of Ksh 57,000", "05:30 PM"));

        return childModelList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}