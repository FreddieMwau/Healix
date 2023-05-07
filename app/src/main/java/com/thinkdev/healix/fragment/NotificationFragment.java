package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.thinkdev.healix.adapter.NotificationAdapter;
import com.thinkdev.healix.databinding.FragmentNotificationBinding;
import com.thinkdev.healix.model.NotificationData;


import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private FragmentNotificationBinding binding;
    private List<NotificationData> data =  new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentNotificationBinding.inflate(inflater, container, false);


        return binding.getRoot();


    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        data.clear();
        data.add(new NotificationData("Confirmed payment of amount Ksh 12,000 from Karen Hospital...",
                "Insurance","Sanlam Insurance","INV 001","Paid","04/03/2023 11:34 am"));



        data.add(new NotificationData("INV 002 status has been updated and the payment process is .....",
                "Insurance","Jubillee Insurance","INV 002","Approved","02/03/2023 03:34 am"));



        data.add(new NotificationData("onfirmed payment of amount Ksh 34,000 from Nairobi Hospital",
                "Insurance","ICEA Insurance","INV 004","Paid","18/03/2023 11:34 am"));



        data.add(new NotificationData("Confirmed payment of amount Ksh 12,000 from Karen Hospital...",
                "Insurance","APA Insurance","INV 003","Pending","02/03/2023 03:34 am"));





        NotificationAdapter adapter = new NotificationAdapter(data);
        binding.rcynotification.setHasFixedSize(true);
        binding.rcynotification.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.rcynotification.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}