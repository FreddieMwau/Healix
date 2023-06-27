package com.thinkdev.healix.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.thinkdev.healix.fragment.LibraryCardFragment;
import com.thinkdev.healix.fragment.LibraryDetailsFragment;

public class ProfileTabsAdapter extends FragmentStateAdapter {

    public ProfileTabsAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LibraryDetailsFragment();
            case 1:
                return new LibraryCardFragment();
            default:
                return new LibraryDetailsFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
