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
import com.thinkdev.healix.adapter.ServiceAdapter;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentHomeBinding;
import com.thinkdev.healix.databinding.FragmentInvoiceServicesBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.ServicesChildModel;
import com.thinkdev.healix.model.ServicesModel;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServicesFragment extends Fragment implements TransactionInterface {
    private FragmentInvoiceServicesBinding binding;
    private ServiceAdapter serviceAdapter;
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
        serviceAdapter = new ServiceAdapter(ServicesItemList(), this);
        serviceRecycler.setAdapter(serviceAdapter);
        serviceRecycler.setLayoutManager(layoutManager);
    }

    private List<ServicesModel> ServicesItemList(){
        List<ServicesModel> servicesModelList = new ArrayList<>();

        ServicesModel transactionalModel = new ServicesModel("25", "Tuesday", "June", "54,000", ServicesChildList());
        servicesModelList.add(transactionalModel);

        return  servicesModelList;
    }

    private List<ServicesChildModel> ServicesChildList(){
        List<ServicesChildModel> childModelList = new ArrayList<>();

        childModelList.add(new ServicesChildModel(R.drawable.service_icon, "#S647398", "Blood count", "3,200", "01:32 PM"));
        childModelList.add(new ServicesChildModel(R.drawable.service_icon, "#S647398", "Blood count", "3,200", "01:32 PM"));
        childModelList.add(new ServicesChildModel(R.drawable.service_icon, "#S647398", "Blood count", "3,200", "01:32 PM"));
        childModelList.add(new ServicesChildModel(R.drawable.service_icon, "#S647398", "Blood count", "3,200", "01:32 PM"));
        childModelList.add(new ServicesChildModel(R.drawable.service_icon, "#S647398", "Blood count", "3,200", "01:32 PM"));

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