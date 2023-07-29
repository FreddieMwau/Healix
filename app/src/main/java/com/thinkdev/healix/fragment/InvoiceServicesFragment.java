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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.activity.InvoiceDetails;
import com.thinkdev.healix.adapter.ServicesAdapter;
import com.thinkdev.healix.databinding.FragmentInvoiceServicesBinding;
import com.thinkdev.healix.interfaces.ServiceInterface;
import com.thinkdev.healix.model.ServicesChildModel;
import com.thinkdev.healix.model.ServicesModel;

import java.util.ArrayList;
import java.util.List;

public class InvoiceServicesFragment extends Fragment implements ServiceInterface {
    private FragmentInvoiceServicesBinding binding;
    RecyclerView serviceRecycler;
    private ServicesAdapter serviceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoiceServicesBinding.inflate(inflater, container, false);
        System.out.println("Got to the invoice service fragment");
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        serviceRecycler = view.findViewById(R.id.servicesRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        serviceAdapter = new ServicesAdapter(ServicesItemList(), getContext(), this);
        serviceRecycler.setAdapter(serviceAdapter);
        serviceRecycler.setLayoutManager(layoutManager);
    }

    private List<ServicesModel> ServicesItemList() {
        List<ServicesModel> servicesModelList = new ArrayList<>();


        ServicesModel servicesModel = new ServicesModel("25", "Tuesday", "June", "54,000", ServicesChildList());
        servicesModelList.add(servicesModel);

        return servicesModelList;
    }

    private List<ServicesChildModel> ServicesChildList() {
        List<ServicesChildModel> childModels = new ArrayList<>();

        childModels.add(new ServicesChildModel("#S57923", "Root Canal", "12:38 PM", "12,000"));
        childModels.add(new ServicesChildModel("#S57923", "Root Canal", "12:38 PM", "12,000"));
        childModels.add(new ServicesChildModel("#S57923", "Root Canal", "12:38 PM", "12,000"));
        childModels.add(new ServicesChildModel("#S57923", "Root Canal", "12:38 PM", "12,000"));

        return childModels;
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

        TextView serviceTitle, procedureTitle, patientName, gender, phoneNumber, amount;
        Button deleteBtn, editBtn;

        serviceTitle = dialog.findViewById(R.id.serviceNumber);
        procedureTitle = dialog.findViewById(R.id.procedureName);
        patientName = dialog.findViewById(R.id.clientName);
        gender = dialog.findViewById(R.id.gender);
        phoneNumber = dialog.findViewById(R.id.servicePhoneNumber);
        amount = dialog.findViewById(R.id.chargeAmount);
        deleteBtn = dialog.findViewById(R.id.deleteServiceBtn);
        editBtn = dialog.findViewById(R.id.editServiceBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Edit Service Button clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Delete Service Button clicked", Toast.LENGTH_SHORT).show();
                openDeleteDialog();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void openDeleteDialog() {
        Toast.makeText(requireContext(), "Delete Invoice clicked", Toast.LENGTH_SHORT).show();
        Dialog dialog = new Dialog(requireContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.delete_bottom_sheet);

        Button yesBtn, noBtn;

        yesBtn = dialog.findViewById(R.id.yesBtn);
        noBtn = dialog.findViewById(R.id.noBtn);

        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "No choice clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Yes choice clicked", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(requireContext(), "Clicked service task", Toast.LENGTH_SHORT).show();
        showBottomServiceSheet();
    }
}