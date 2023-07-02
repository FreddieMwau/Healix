package com.thinkdev.healix.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.thinkdev.healix.fragment.InvoicePaymentsFragment;
import com.thinkdev.healix.fragment.InvoiceServicesFragment;

public class InvoiceTabAdapter extends FragmentStateAdapter {

    public InvoiceTabAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new InvoiceServicesFragment();
            case 1:
                return new InvoicePaymentsFragment();
            default:
                return new InvoiceServicesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
