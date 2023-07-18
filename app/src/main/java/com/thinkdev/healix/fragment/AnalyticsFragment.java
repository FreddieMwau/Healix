package com.thinkdev.healix.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.thinkdev.healix.R;
import com.thinkdev.healix.Singleton.FilterDataHolder;
import com.thinkdev.healix.activity.InvoiceDetails;
import com.thinkdev.healix.adapter.FilterAdapter;
import com.thinkdev.healix.adapter.TransactionAdapter;
import com.thinkdev.healix.databinding.FragmentAnalyticsBinding;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.FilterData;
import com.thinkdev.healix.model.FilterDataModel;
import com.thinkdev.healix.model.TransactionChildModel;
import com.thinkdev.healix.model.TransactionalModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class AnalyticsFragment extends Fragment implements TransactionInterface {
    private FragmentAnalyticsBinding binding;
    private TransactionAdapter transactionAdapter;
    private RecyclerView transactionRecycler, filterRecycler;
    private CardView filter, clearFilter;
    private LinearLayout filterLayout;
    private List<FilterDataModel> filterDataList;
    private FilterAdapter filterAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAnalyticsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        transactionRecycler = view.findViewById(R.id.analyticsRecycler);
        filter = view.findViewById(R.id.analytics_filters_card);
        filterRecycler = view.findViewById(R.id.filtersRecyclerView);
        filterLayout = view.findViewById(R.id.filterResultLayout);
        clearFilter = view.findViewById(R.id.clear_filters_card);

        filterDataList = new ArrayList<>();
        filterAdapter = new FilterAdapter(filterDataList);
        filterRecycler.setAdapter(filterAdapter);
        filterRecycler.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterBottomSheetDialog();
            }
        });

        clearFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFilter();
                MotionToast.Companion.darkToast((Activity) requireContext(),
                        "Success",
                        "Filters cleared successfully",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION,
                        ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        transactionAdapter = new TransactionAdapter(TransactionItemList(), getContext(), this);
        transactionRecycler.setAdapter(transactionAdapter);
        transactionRecycler.setLayoutManager(layoutManager);

        FilterData filterData = FilterDataHolder.getInstance().getFilterData();
        if (filterData != null && !isFilterDataEmpty(filterData)) {
            filter.setVisibility(View.GONE);
            filterRecycler.setVisibility(View.VISIBLE);
            filterLayout.setVisibility(View.VISIBLE);
            clearFilter.setVisibility(View.VISIBLE);

            updateFilterData(filterData);
        }
    }

    private void clearFilter() {
        filterDataList.clear();
        filterAdapter.notifyDataSetChanged();

        filterRecycler.setVisibility(View.GONE);
        filterLayout.setVisibility(View.GONE);
        clearFilter.setVisibility(View.GONE);
        filter.setVisibility(View.VISIBLE);

        FilterDataHolder.getInstance().setFilterData(null);
    }

    private boolean isFilterDataEmpty(FilterData filterData) {
        return  TextUtils.isEmpty(filterData.getCompanyText()) &&
                TextUtils.isEmpty(filterData.getPaymentStatus()) &&
                TextUtils.isEmpty(filterData.getMonthYear());
    }

    @SuppressLint("NotifyDataSetChanged")
    private void updateFilterData(FilterData filterData) {
        filterDataList.clear();

        // Add the selected filter data to the filterDataList
        if (!TextUtils.isEmpty(filterData.getCompanyText())) {
            filterDataList.add(new FilterDataModel("Company",filterData.getCompanyText()));
        }
        if (!TextUtils.isEmpty(filterData.getPaymentStatus())) {
            filterDataList.add(new FilterDataModel("Payment Status", filterData.getPaymentStatus()));
        }
        if (!TextUtils.isEmpty(filterData.getMonthYear())) {
            filterDataList.add(new FilterDataModel("Month/Year", filterData.getMonthYear()));
        }

        // Notify the adapter that data has changed
        filterAdapter.notifyDataSetChanged();
    }

    private void openFilterBottomSheetDialog() {
        final Dialog dialog = new Dialog(getContext());
        final int checkedColor = ContextCompat.getColor(requireContext() ,R.color.white);
        final int uncheckedColor = ContextCompat.getColor(requireContext(), R.color.blue);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.filter_bottom_sheet);

        String[] insurances = {"Sanlam", "Madison", "APA", "Pioneer", "AAR"};
        Button monthYearBtn = dialog.findViewById(R.id.monthPickerBtn);
        Button saveFilterBtn = dialog.findViewById(R.id.saveFilterBtn);
        AutoCompleteTextView filterCompany = dialog.findViewById(R.id.auto_filter_company_txt);
        ArrayAdapter<String> companyAdapter;
        RadioGroup statusBtn = dialog.findViewById(R.id.filterRadioGroupBtn);

        companyAdapter = new ArrayAdapter<>(requireContext(),R.layout.insurance_list, insurances);
        filterCompany.setThreshold(2);
        filterCompany.setAdapter(companyAdapter);

        MaterialDatePicker datePicker = MaterialDatePicker.Builder
                .datePicker()
                .setTitleText("Select month and year")
                .setTheme(R.style.MaterialCalendarTheme)
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        monthYearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getChildFragmentManager(), "Select start date of month");
                datePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
                        calendar.setTimeInMillis(selection);
                        int selectedYear = calendar.get(Calendar.YEAR);

                        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
                        String abbreviatedMonth = dateFormat.format(calendar.getTime());
                        monthYearBtn.setText(abbreviatedMonth + ", " + selectedYear);
                    }
                });
            }
        });

        statusBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i = 0; i < count; i++){
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() == checkedId){
                        Toast.makeText(requireContext(), radioButton.getText() + " clicked", Toast.LENGTH_SHORT).show();
                        radioButton.setTextColor(checkedColor);
                    } else {
                        radioButton.setTextColor(uncheckedColor);
                    }
                }
            }
        });


        saveFilterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MotionToast.Companion.darkToast((Activity) requireContext(),
                        "Success",
                        "Filters saved successfully",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION,
                        ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular));

                String companyText = filterCompany.getText().toString();
                String paymentStatus = "";
                int selectedRadioBtn = statusBtn.getCheckedRadioButtonId();

                if (selectedRadioBtn != -1){
                    RadioButton selecetdStatus = dialog.findViewById(selectedRadioBtn);
                    paymentStatus = selecetdStatus.getText().toString();
                }

                String monthYear = monthYearBtn.getText().toString();
                FilterData filterData = new FilterData(companyText, paymentStatus, monthYear);
                FilterDataHolder.getInstance().setFilterData(filterData);
                updateFilterData(filterData);

                if (!isFilterDataEmpty(filterData)){
                    filter.setVisibility(View.GONE);
                    filterLayout.setVisibility(View.VISIBLE);
                    filterRecycler.setVisibility(View.VISIBLE);
                    clearFilter.setVisibility(View.VISIBLE);

                    updateFilterData(filterData);
                    FilterDataHolder.getInstance().setFilterData(filterData);
                } else {
                    Toast.makeText(requireContext(), "Filter data is empty", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
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