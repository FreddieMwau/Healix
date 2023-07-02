package com.thinkdev.healix.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.thinkdev.healix.databinding.FragmentInvoicesBinding;

public class InvoicesFragment extends Fragment {

    private FragmentInvoicesBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentInvoicesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}