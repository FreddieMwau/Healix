package com.thinkdev.healix.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.adapter.ServiceAdapter;
import com.thinkdev.healix.databinding.FragmentInvoiceServicesBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.ServicesChildModel;
import com.thinkdev.healix.model.ServicesModel;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServicesFragment extends Fragment implements TransactionInterface{
    private FragmentInvoiceServicesBinding binding;
    private ServiceAdapter serviceAdapter;
    RecyclerView serviceRecycler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoiceServicesBinding.inflate(inflater, container, false);
        System.out.println("Got to this fragment");
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        serviceRecycler = view.findViewById(R.id.servicesRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        serviceAdapter = new ServiceAdapter(ServicesItemList(), getContext(), this::onItemClicked);
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

    private void showBottomServiceSheet() {
        System.out.println("Got here");
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.service_layout_design);
        System.out.println("Got here");

//        LinearLayout service = dialog.findViewById()
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public void onItemClicked(int position) {
        System.out.println("CLicked and logged this");
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show();
    }
}