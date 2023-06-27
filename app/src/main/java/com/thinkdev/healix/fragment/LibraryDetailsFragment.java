package com.thinkdev.healix.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thinkdev.healix.R;
import com.thinkdev.healix.databinding.FragmentLibraryDetailsBinding;

public class LibraryDetailsFragment extends Fragment {

    private FragmentLibraryDetailsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLibraryDetailsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}