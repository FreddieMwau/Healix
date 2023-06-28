package com.thinkdev.healix.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentHomeBinding;
import com.thinkdev.healix.databinding.FragmentInvoiceServicesBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServicesFragment extends Fragment {
    private FragmentInvoiceServicesBinding binding;
    private TransactionAdapter transactionAdapter;
    RecyclerView serviceRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoiceServicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        serviceRecycler = view.findViewById(R.id.servicesRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//        transactionAdapter = new TransactionAdapter(TransactionItemList(), getContext(), this);
        serviceRecycler.setAdapter(transactionAdapter);
        serviceRecycler.setLayoutManager(layoutManager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}