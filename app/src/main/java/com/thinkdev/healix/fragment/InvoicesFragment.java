package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.thinkdev.healix.adapter.InvoicesAdapter;
import com.thinkdev.healix.adapter.NotificationAdapter;
import com.thinkdev.healix.databinding.FragmentInvoicesBinding;
import com.thinkdev.healix.model.InvoicesData;
import com.thinkdev.healix.model.NotificationData;

import java.util.ArrayList;
import java.util.List;

public class InvoicesFragment extends Fragment {
    private List<InvoicesData> data =  new ArrayList<>();
    private FragmentInvoicesBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentInvoicesBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data.clear();
        data.add(new InvoicesData("Confirmed payment of amount Ksh 12,000 from Karen Hospital...",
                "Insurance","Sanlam Insurance","INV 001","Paid","04/03/2023 11:34 am"));



        data.add(new InvoicesData("INV 002 status has been updated and the payment process is .....",
                "Insurance","Jubillee Insurance","INV 002","Approved","02/03/2023 03:34 am"));



        data.add(new InvoicesData("onfirmed payment of amount Ksh 34,000 from Nairobi Hospital",
                "Insurance","ICEA Insurance","INV 004","Paid","18/03/2023 11:34 am"));



        data.add(new InvoicesData("Confirmed payment of amount Ksh 12,000 from Karen Hospital...",
                "Insurance","APA Insurance","INV 003","Pending","02/03/2023 03:34 am"));





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