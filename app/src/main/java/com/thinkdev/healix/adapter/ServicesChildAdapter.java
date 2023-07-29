package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.interfaces.ServiceInterface;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.ServicesChildModel;
import com.thinkdev.healix.model.ServicesModel;

import java.util.List;

public class ServicesChildAdapter extends RecyclerView.Adapter<ServicesChildAdapter.ServicesChildViewHolder> {
    private List<ServicesChildModel> servicesModelList;
    private ServiceInterface serviceInterface;

    public ServicesChildAdapter(List<ServicesChildModel> servicesModelList) {
        this.servicesModelList = servicesModelList;
    }

    @NonNull
    @Override
    public ServicesChildAdapter.ServicesChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_card_design, parent, false);
        return new ServicesChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesChildAdapter.ServicesChildViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return servicesModelList.size();
    }

    public void setOnItemClickListener(ServiceInterface serviceInterfaces) {
        this.serviceInterface = serviceInterfaces;
    }

    public class ServicesChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, description, time, amount;

        public ServicesChildViewHolder(@NonNull View itemView) {
            super(itemView);

            amount = itemView.findViewById(R.id.serviceAmount);
            title = itemView.findViewById(R.id.serviceTitle);
            description = itemView.findViewById(R.id.serviceDescription);
            time = itemView.findViewById(R.id.serviceTime);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (serviceInterface != null){
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION){
                    serviceInterface.onItemClicked(pos);
                }
            }
        }
    }
}
