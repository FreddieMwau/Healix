package com.thinkdev.healix.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.activity.InvoiceDetails;
import com.thinkdev.healix.activity.NewInvoiceActivity;
import com.thinkdev.healix.activity.Notification;
import com.thinkdev.healix.activity.ProfileActivity;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentLibraryBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment implements TransactionInterface {
    private FragmentLibraryBinding binding;
    private TransactionAdapter transactionAdapter;
    RecyclerView transactionRecycler;
    ImageView profile, search, notification, add;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        transactionRecycler = view.findViewById(R.id.libraryRecycler);
        profile = view.findViewById(R.id.profileImg);
        notification = view.findViewById(R.id.libraryNotificationIcon);
        add = view.findViewById(R.id.libraryAddIcon);
        search = view.findViewById(R.id.librarySearchIcon);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionAdapter = new TransactionAdapter(TransactionItemList(), getContext(), this);
        transactionRecycler.setAdapter(transactionAdapter);
        transactionRecycler.setLayoutManager(layoutManager);


        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), ProfileActivity.class);
                startActivity(i);
            }
        });


        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Notification.class);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotBottomSheetDialog();
            }
        });
    }

    private void shotBottomSheetDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.invoice_service_bottom_sheet);

        LinearLayout invoice = dialog.findViewById(R.id.invoiceLayout);

        invoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), NewInvoiceActivity.class);
                startActivity(i);
            }
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.BottomDialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private List<TransactionalModel> TransactionItemList() {
        List<TransactionalModel> transactionalModelList = new ArrayList<>();

        TransactionalModel transactionalModel = new TransactionalModel("25", "Tuesday", "June", "54,000", TransactionChildList());
        transactionalModelList.add(transactionalModel);
        TransactionalModel transactionalModel1 = new TransactionalModel("25", "Tuesday", "June", "54,000", TransactionChildList());
        transactionalModelList.add(transactionalModel1);

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
        Intent i = new Intent(requireContext(), InvoiceDetails.class);
        startActivity(i);
    }
}