package com.thinkdev.healix.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.FragmentLibraryCardBinding;
import com.thinkdev.healix.databinding.FragmentLibraryDetailsBinding;

public class LibraryCardFragment extends Fragment {

    private FragmentLibraryCardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryCardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}