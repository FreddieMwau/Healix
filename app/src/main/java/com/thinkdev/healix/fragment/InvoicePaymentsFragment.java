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
import com.thinkdev.healix.databinding.FragmentInvoicePaymentsBinding;
import com.thinkdev.healix.databinding.FragmentInvoiceServicesBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;

public class InvoicePaymentsFragment extends Fragment implements TransactionInterface {

    private FragmentInvoicePaymentsBinding binding;
    private TransactionAdapter transactionAdapter;
    RecyclerView paymentsRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoicePaymentsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        paymentsRecycler = view.findViewById(R.id.paymentsRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionAdapter = new TransactionAdapter(TransactionItemList(), getContext(), this);
        paymentsRecycler.setAdapter(transactionAdapter);
        paymentsRecycler.setLayoutManager(layoutManager);
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

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show();
    }
}