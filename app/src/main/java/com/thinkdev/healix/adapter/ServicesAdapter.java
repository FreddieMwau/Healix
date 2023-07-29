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
import com.thinkdev.healix.interfaces.ServiceInterface;
import com.thinkdev.healix.model.ServicesModel;

import java.util.List;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<ServicesModel> servicesModelList;
    private ServiceInterface serviceInterface;

    public ServicesAdapter(List<ServicesModel> servicesModelList, Context context, ServiceInterface serviceInterface) {
        this.servicesModelList = servicesModelList;
        this.serviceInterface = serviceInterface;
    }

    @NonNull
    @Override
    public ServicesAdapter.ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_group_card, parent, false);
        return new ServicesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ServicesViewHolder holder, int position) {
        ServicesModel servicesModel = servicesModelList.get(position);
        holder.transactionDate.setText(servicesModel.getDate());
        holder.transactionDay.setText(servicesModel.getDay());
        holder.transactionMonth.setText(servicesModel.getMonth());
        holder.transactionTotal.setText(servicesModel.getAmount());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.transactionRecycler.getContext(), LinearLayoutManager.VERTICAL, false);

        layoutManager.setInitialPrefetchItemCount(servicesModel.getChildItemList().size());

        ServicesChildAdapter servicesChildAdapter = new ServicesChildAdapter(servicesModel.getChildItemList());
        servicesChildAdapter.setOnItemClickListener(serviceInterface);
        holder.transactionRecycler.setLayoutManager(layoutManager);
        holder.transactionRecycler.setAdapter(servicesChildAdapter);
        holder.transactionRecycler.setRecycledViewPool(viewPool);

    }

    @Override
    public int getItemCount() {
        return servicesModelList.size();
    }

    public class ServicesViewHolder extends RecyclerView.ViewHolder {
        private TextView transactionDate, transactionDay, transactionMonth, transactionTotal;
        private RecyclerView transactionRecycler;
        public ServicesViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionDate = itemView.findViewById(R.id.transactionDate);
            transactionDay = itemView.findViewById(R.id.transactionDay);
            transactionMonth = itemView.findViewById(R.id.transactionMonth);
            transactionTotal = itemView.findViewById(R.id.transactionAmount);
            transactionRecycler = (RecyclerView) itemView.findViewById(R.id.transaction_nested_recycler);
        }
    }
}
