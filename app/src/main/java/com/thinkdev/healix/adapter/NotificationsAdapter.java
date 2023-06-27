package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.model.NotificationParentModel;


import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<NotificationParentModel> notificationParentModelList;

    public NotificationsAdapter(List<NotificationParentModel> notificationParentModelList) {
        this.notificationParentModelList = notificationParentModelList;
    }

    @NonNull
    @Override
    public NotificationsAdapter.NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_group_card, parent, false);
        return new NotificationsAdapter.NotificationsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsAdapter.NotificationsViewHolder holder, int position) {
        NotificationParentModel parentModel = notificationParentModelList.get(position);

        holder.date.setText(parentModel.getDate());
        holder.day.setText(parentModel.getDay());
        holder.month.setText(parentModel.getMonth());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.notificationRecyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(parentModel.getNotificationChildModelList().size());

        NotificationsChildAdapter childAdapter = new NotificationsChildAdapter(parentModel.getNotificationChildModelList());
        holder.notificationRecyclerView.setLayoutManager(layoutManager);
        holder.notificationRecyclerView.setAdapter(childAdapter);
        holder.notificationRecyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return notificationParentModelList.size();
    }

    public class NotificationsViewHolder extends RecyclerView.ViewHolder {

        TextView date, day, month;
        RecyclerView notificationRecyclerView;
        public NotificationsViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.notificationDate);
            day = itemView.findViewById(R.id.notificationDay);
            month = itemView.findViewById(R.id.notificationMonth);
            notificationRecyclerView = itemView.findViewById(R.id.notification_nested_recycler);
        }
    }
}
