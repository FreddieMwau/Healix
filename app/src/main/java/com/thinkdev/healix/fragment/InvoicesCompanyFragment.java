package com.thinkdev.healix.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.activity.InvoiceDetails;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentInvoicesCompanyBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;

public class InvoicesCompanyFragment extends Fragment implements TransactionInterface {
    private FragmentInvoicesCompanyBinding binding;
    RecyclerView invoicesRecycler;
    private TransactionAdapter transactionAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoicesCompanyBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        invoicesRecycler = view.findViewById(R.id.invoicesCompanyRecyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionAdapter = new TransactionAdapter(TransactionItemList(), getContext(), this);
        invoicesRecycler.setAdapter(transactionAdapter);
        invoicesRecycler.setLayoutManager(layoutManager);

    }

    private List<TransactionalModel> TransactionItemList() {
        List<TransactionalModel> transactionalModelList = new ArrayList<>();

        TransactionalModel transactionalModel = new TransactionalModel("26", "Wednesday", "July", "54,000", TransactionChildList());
        transactionalModelList.add(transactionalModel);

        return  transactionalModelList;
    }

    private List<TransactionChildModel> TransactionChildList() {
        List<TransactionChildModel> childModelList = new ArrayList<>();

        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 56, "Sanlam", "Confirmed payment on #INV3672891 of Ksh 34,000", "12:38 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 34, "Sanlam", "Confirmed payment on #INV3674324 of Ksh 93,000", "06:19 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 80, "Sanlam", "Confirmed payment on #INV3672891 of Ksh 40,000", "09:45 AM"));
        childModelList.add(new TransactionChildModel(R.drawable.sanlam, 67, "Sanlam", "Confirmed payment on #INV3672891 of Ksh 76,000", "12:05 PM"));

        return childModelList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClicked(int position) {
        Intent i = new Intent(requireContext(), InvoiceDetails.class);
        startActivity(i);
    }
}