package com.thinkdev.healix.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.ServicesModel;

import java.util.List;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<ServicesModel> servicesModels;
    private TransactionInterface transactionInterface;

    public ServiceAdapter(List<ServicesModel> servicesModels, TransactionInterface transactionInterface) {
        this.servicesModels = servicesModels;
        this.transactionInterface = transactionInterface;
    }

    @NonNull
    @Override
    public ServiceAdapter.ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_group_card, parent, false);
        return new ServiceAdapter.ServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceAdapter.ServiceViewHolder holder, int position) {
        ServicesModel servicesModel = servicesModels.get(position);
        holder.transactionDate.setText(servicesModel.getDate());
        holder.transactionDay.setText(servicesModel.getDay());
        holder.transactionMonth.setText(servicesModel.getMonth());
        holder.transactionTotal.setText(servicesModel.getAmount());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.transactionRecycler.getContext(), LinearLayoutManager.VERTICAL, false);

        layoutManager.setInitialPrefetchItemCount(servicesModel.getChildModelList().size());

        ServicesChildAdapter childAdapter = new ServicesChildAdapter(servicesModel.getChildModelList());
        childAdapter.setOnItemClickListener(transactionInterface);
        holder.transactionRecycler.setLayoutManager(layoutManager);
        holder.transactionRecycler.setAdapter(childAdapter);
        holder.transactionRecycler.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return servicesModels.size();
    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {
        private TextView transactionDate, transactionDay, transactionMonth, transactionTotal;
        private RecyclerView transactionRecycler;
        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionDate = itemView.findViewById(R.id.transactionDate);
            transactionDay = itemView.findViewById(R.id.transactionDay);
            transactionMonth = itemView.findViewById(R.id.transactionMonth);
            transactionTotal = itemView.findViewById(R.id.transactionAmount);
            transactionRecycler = (RecyclerView) itemView.findViewById(R.id.transaction_nested_recycler);
        }
    }
}
