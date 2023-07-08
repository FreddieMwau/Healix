package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.interfaces.ServiceInterface;
import com.thinkdev.healix.model.ServicesChildModel;

import java.util.List;

public class ServicesChildAdapter extends RecyclerView.Adapter<ServicesChildAdapter.ServicesViewHolder> {

    private List<ServicesChildModel> servicesChildModels;
    private ServiceInterface serviceInterface;

    public ServicesChildAdapter(List<ServicesChildModel> servicesChildModels) {
        this.servicesChildModels = servicesChildModels;
    }

    @NonNull
    @Override
    public ServicesChildAdapter.ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_card_design, parent, false);
        return new ServicesChildAdapter.ServicesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesChildAdapter.ServicesViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return servicesChildModels.size();
    }

    public void setOnItemClickListener(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public class ServicesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView icon;
        TextView title, description, amount, time;
        public ServicesViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.serviceTitle);
            description = itemView.findViewById(R.id.serviceDescription);
            amount = itemView.findViewById(R.id.serviceAmount);
            time = itemView.findViewById(R.id.serviceTime);
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
