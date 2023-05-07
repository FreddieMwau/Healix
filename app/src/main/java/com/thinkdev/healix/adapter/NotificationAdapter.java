package com.thinkdev.healix.adapter;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.model.NotificationData;

import java.util.ArrayList;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder>{
    private List<NotificationData> listdata;

    // RecyclerView recyclerView;
    public NotificationAdapter(List<NotificationData> listdata) {
        this.listdata = listdata;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_notification, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTv.setText(listdata.get(position).getNameTv());
        holder.subnameTv.setText(listdata.get(position).getSubnameTv());
        holder.desTv.setText(listdata.get(position).getDesTv());
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
            this.nameTv = (TextView) itemView.findViewById(R.id.nameTv);
            this.subnameTv = (TextView) itemView.findViewById(R.id.subnameTv);
            this.desTv = (TextView) itemView.findViewById(R.id.desTv);
            this.invTitle = (TextView) itemView.findViewById(R.id.invTitle);
            this.invDate = (TextView) itemView.findViewById(R.id.invDate);
            btn = (AppCompatButton) itemView.findViewById(R.id.paidBtn);
        }
    }
}