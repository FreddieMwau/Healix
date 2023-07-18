package com.thinkdev.healix.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.thinkdev.healix.fragment.HistoryFragment;
import com.thinkdev.healix.fragment.InvoicePaymentsFragment;

public class CompanyTabAdapter extends FragmentStateAdapter {

    public CompanyTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HistoryFragment();
            case 1:
//                return new InvoicesFragment();
            default:
                return new HistoryFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
