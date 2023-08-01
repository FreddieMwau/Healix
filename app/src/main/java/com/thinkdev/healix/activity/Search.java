package com.thinkdev.healix.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.ActivitySearchBinding;

public class Search extends AppCompatActivity {

    private ActivitySearchBinding binding;
    RecyclerView searchRecycler;
    EditText searchInput;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        searchInput = findViewById(R.id.searchTextView);
        searchRecycler = findViewById(R.id.searchRecyclerView);
        radioGroup = findViewById(R.id.searchRadioGroupBtn);
        final int checkedColor = ContextCompat.getColor(getApplicationContext() ,R.color.blue);
        final int uncheckedColor = ContextCompat.getColor(getApplicationContext(), R.color.white);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int count = group.getChildCount();
                for (int i = 0; i < count; i++){
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.getId() == checkedId){
                        radioButton.setTextColor(checkedColor);
                    } else {
                        radioButton.setTextColor(uncheckedColor);
                    }
                }
            }
        });
    }

    public void onSearchBackIconClicked(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}