package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.interfaces.ServiceInterface;
import com.thinkdev.healix.model.ServicesChildModel;

import java.util.List;

public class ServiceChildAdapter extends RecyclerView.Adapter<ServiceChildAdapter.ServiceChildViewHolder> {

    private List<ServicesChildModel> childModels;
    private ServiceInterface serviceInterface;

    public ServiceChildAdapter(List<ServicesChildModel> childModels) {
        this.childModels = childModels;
    }

    @NonNull
    @Override
    public ServiceChildAdapter.ServiceChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_card_design, parent, false);
        return new ServiceChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceChildAdapter.ServiceChildViewHolder holder, int position) {
        ServicesChildModel servicesChildModel = childModels.get(position);
        holder.serviceTitle.setText(servicesChildModel.getTitle());
        holder.serviceTask.setText(servicesChildModel.getDescription());
        holder.serviceAmount.setText(servicesChildModel.getAmount());
        holder.serviceDate.setText(servicesChildModel.getTime());
    }

    @Override
    public int getItemCount() {
        return childModels.size();
    }

    public void setOnServiceClickListener(ServiceInterface serviceInterface){
        this.serviceInterface = serviceInterface;
    }

    public class ServiceChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView serviceTitle, serviceTask, serviceAmount, serviceDate;
        public ServiceChildViewHolder(@NonNull View itemView) {
            super(itemView);
            serviceTitle = itemView.findViewById(R.id.serviceTitle);
            serviceTask = itemView.findViewById(R.id.serviceDescription);
            serviceAmount = itemView.findViewById(R.id.serviceAmount);
            serviceDate = itemView.findViewById(R.id.serviceTime);
        }

        @Override
        public void onClick(View v) {
            if (serviceInterface != null){
                int pos = getAdapterPosition();
                System.out.println("Services position >>>> " + pos);
                if (pos != RecyclerView.NO_POSITION){
                    serviceInterface.onItemClicked(pos);
                }
            }
        }
    }
}
