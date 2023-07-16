package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.thinkdev.healix.R;
import com.thinkdev.healix.model.FilterDataModel;

import java.util.List;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.FilterViewHolder> {

    private List<FilterDataModel> filterDataModels;


    public FilterAdapter(List<FilterDataModel> filterDataModels) {
        this.filterDataModels = filterDataModels;
    }

    @NonNull
    @Override
    public FilterAdapter.FilterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.filters_card_design, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.FilterViewHolder holder, int position) {
        FilterDataModel filterModel = filterDataModels.get(position);
        holder.bind(filterModel);
    }

    @Override
    public int getItemCount() {
        return filterDataModels.size();
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder {
        private TextView filterText;
        public FilterViewHolder(@NonNull View itemView) {
            super(itemView);
            filterText = itemView.findViewById(R.id.filterText);
        }

        public void bind(FilterDataModel filterModel) {
            filterText.setText(filterModel.getSelectedValue());
        }
    }
}
