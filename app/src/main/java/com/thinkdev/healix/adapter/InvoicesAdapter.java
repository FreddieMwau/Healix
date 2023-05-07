package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.model.InvoicesData;
import com.thinkdev.healix.model.NotificationData;

import java.util.List;

public class InvoicesAdapter extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder>{
    private List<InvoicesData> listdata;

    // RecyclerView recyclerView;
    public InvoicesAdapter(List<InvoicesData> listdata) {
        this.listdata = listdata;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_invoice, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTv.setText(listdata.get(position).getNameTv());
        holder.subnameTv.setText(listdata.get(position).getSubnameTv());
//        holder.desTv.setText(listdata.get(position).getDesTv());
        holder.invTitle.setText(listdata.get(position).getInvTitle());
        holder.invDate.setText(listdata.get(position).getInvdate());
//        holder.btn.setBackgroundTintList(ColorStateList.valueOf(resources.getColor(R.id.white)));


    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatButton btn;
        public TextView invTitle,nameTv,subnameTv,invDate,desTv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.nameTv = (TextView) itemView.findViewById(R.id.nameTvHos);
            this.subnameTv = (TextView) itemView.findViewById(R.id.namesubHos);

            this.invTitle = (TextView) itemView.findViewById(R.id.invTitle);
            this.invDate = (TextView) itemView.findViewById(R.id.invDate);
            btn = (AppCompatButton) itemView.findViewById(R.id.paidBtn);
        }
    }
}