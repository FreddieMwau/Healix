package com.thinkdev.healix.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.tabs.TabLayout;
import com.thinkdev.healix.R;
import com.thinkdev.healix.Singleton.CompanyFilterDataHolder;
import com.thinkdev.healix.Singleton.FilterDataHolder;
import com.thinkdev.healix.adapter.CompanyTabAdapter;
import com.thinkdev.healix.adapter.FilterAdapter;
import com.thinkdev.healix.databinding.ActivityCompanyBinding;
import com.thinkdev.healix.model.CompanyDataFilter;
import com.thinkdev.healix.model.FilterDataModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Company extends AppCompatActivity {

    private ActivityCompanyBinding binding;
    CardView filterBtn, clearBtn;
    private List<FilterDataModel> filterDataList;
    private FilterAdapter filterAdapter;
    private RecyclerView filterRecycler;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    CompanyTabAdapter tabAdapter;
    private int invoiceFragmentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCompanyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        invoiceFragmentIndex = 1;
        filterBtn = findViewById(R.id.company_filters_card);
        clearBtn = findViewById(R.id.clear_company_filters_card);
        filterRecycler = findViewById(R.id.companyFiltersRecyclerView);
        tabLayout = findViewById(R.id.companyTabLayout);
        viewPager = findViewById(R.id.companyViewPager);
        tabAdapter = new CompanyTabAdapter(this);
        viewPager.setAdapter(tabAdapter);

        filterDataList = new ArrayList<>();
        filterAdapter = new FilterAdapter(filterDataList);
        filterRecycler.setAdapter(filterAdapter);
        filterRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterBottomSheet();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFilter();
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    private void clearFilter() {
        filterDataList.clear();
        filterAdapter.notifyDataSetChanged();

        filterRecycler.setVisibility(View.GONE);
        clearBtn.setVisibility(View.GONE);
        filterBtn.setVisibility(View.VISIBLE);

        MotionToast.Companion.darkToast(Company.this,
                "Success",
                "Filters cleared successfully",
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.SHORT_DURATION,
                ResourcesCompat.getFont(getApplicationContext(), www.sanju.motiontoast.R.font.helvetica_regular));


        FilterDataHolder.getInstance().setFilterData(null);
    }

    private void openFilterBottomSheet() {
        Dialog dialog = new Dialog(this);
        int checkedColor = ContextCompat.getColor(this ,R.color.white);
        int uncheckedColor = ContextCompat.getColor(this, R.color.blue);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.company_filter_bottom_sheet);

        Button monthYearBtn = dialog.findViewById(R.id.companyFilterMonthPickerBtn);
        Button saveFilterBtn = dialog.findViewById(R.id.companySaveFilterBtn);
        RadioGroup statusBtn = dialog.findViewById(R.id.companyFiltersRadioGroupStatusBtn);


        MaterialDatePicker datePicker = MaterialDatePicker.Builder
                .datePicker()
                .setTitleText("Select month and year")
                .setTheme(R.style.MaterialCalendarTheme)
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();

        monthYearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show(getSupportFragmentManager(), "Select start date of month");
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
                        Toast.makeText(getApplicationContext(), radioButton.getText() + " clicked", Toast.LENGTH_SHORT).show();
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
                MotionToast.Companion.darkToast(Company.this,
                        "Success",
                        "Filters saved successfully",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.SHORT_DURATION,
                        ResourcesCompat.getFont(getApplicationContext(), www.sanju.motiontoast.R.font.helvetica_regular));

                String paymentStatus = "";
                int selectedRadioBtn = statusBtn.getCheckedRadioButtonId();

                if (selectedRadioBtn != -1){
                    RadioButton selectedStatus = dialog.findViewById(selectedRadioBtn);
                    paymentStatus = selectedStatus.getText().toString();
                }

                String monthYear = monthYearBtn.getText().toString();
                CompanyDataFilter companyDataFilter = new CompanyDataFilter(paymentStatus, monthYear);
                CompanyFilterDataHolder.getInstance().setCompanyDataFilter(companyDataFilter);
                updateCompanyFilterData(companyDataFilter);

                if (!isCompanyFilterDataEmpty(companyDataFilter)){
                    filterBtn.setVisibility(View.GONE);
                    filterRecycler.setVisibility(View.VISIBLE);
                    clearBtn.setVisibility(View.VISIBLE);

                    updateCompanyFilterData(companyDataFilter);
                    CompanyFilterDataHolder.getInstance().setCompanyDataFilter(companyDataFilter);
                } else {
                    Toast.makeText(getApplicationContext(), "Filter data is empty", Toast.LENGTH_SHORT).show();
                }

                if (viewPager.getCurrentItem() != invoiceFragmentIndex) {
                    viewPager.setCurrentItem(invoiceFragmentIndex, true);
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

    private boolean isCompanyFilterDataEmpty(CompanyDataFilter companyFilterData) {
        return  TextUtils.isEmpty(companyFilterData.getPaymentStatus()) &&
                TextUtils.isEmpty(companyFilterData.getMonthYear());
    }

    private void updateCompanyFilterData(CompanyDataFilter companyDataFilter) {
        filterDataList.clear();

        if (!TextUtils.isEmpty(companyDataFilter.getPaymentStatus())) {
            filterDataList.add(new FilterDataModel("Payment Status", companyDataFilter.getPaymentStatus()));
        }
        if (!TextUtils.isEmpty(companyDataFilter.getMonthYear())) {
            filterDataList.add(new FilterDataModel("Month/Year", companyDataFilter.getMonthYear()));
        }

        // Notify the adapter that data has changed
        filterAdapter.notifyDataSetChanged();
    }

    public void onBackIconClicked(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}