package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.anychart.chart.common.listener.Event;
import com.anychart.chart.common.listener.ListenersInterface;
import com.anychart.enums.Align;
import com.anychart.enums.LegendLayout;
import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.InvoicesAdapter;
import com.thinkdev.healix.adapter.NotificationAdapter;
import com.thinkdev.healix.databinding.FragmentHomeBinding;
import com.thinkdev.healix.model.InvoicesData;
import com.thinkdev.healix.model.NotificationData;

import java.util.ArrayList;
import java.util.List;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.charts.Pie;

import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private List<InvoicesData> data =  new ArrayList<>();
    AnyChartView pieChart;

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
        pieChart = view.findViewById(R.id.any_pie_chart_view);
        Pie pie = AnyChart.pie();

        List<DataEntry> pieData = new ArrayList<>();
        pieData.add(new ValueDataEntry("Approved", 52000));
        pieData.add(new ValueDataEntry("Paid", 42000));
        pieData.add(new ValueDataEntry("Pending", 32000));

        pie.data(pieData);
        pie.title("Doctors summary payment chart (in Ksh)");
        pie.title().fontSize(14);
        pie.labels().position("inside");


        pie.legend().title().enabled(true);
        pie.legend().title().fontSize(12);
        pie.legend().title()
                        .text("Payment Status")
                        .padding(0d,0d,10d,0d);

        pie.legend()
                .position("center-bottom")
                .itemsLayout(LegendLayout.HORIZONTAL_EXPANDABLE)
                .align(Align.CENTER);
        pieChart.setChart(pie);


        data.clear();
        data.add(new InvoicesData("Confirmed payment of amount Ksh 12,000 from Karen Hospital...",
                "Insurance","Sanlam Insurance","INV 001","Paid","04/03/2023 11:34 am"));



        data.add(new InvoicesData("INV 002 status has been updated and the payment process is .....",
                "Insurance","Jubillee Insurance","INV 002","Approved","02/03/2023 03:34 am"));



        InvoicesAdapter adapter = new InvoicesAdapter(data);
        binding.rcyinvoices.setHasFixedSize(true);
        binding.rcyinvoices.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.rcyinvoices.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}