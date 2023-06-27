package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.thinkdev.healix.R;
import com.thinkdev.healix.model.NotificationChildModel;

import java.util.List;

public class NotificationsChildAdapter extends RecyclerView.Adapter<NotificationsChildAdapter.NotificationsChildViewHolder> {

    private List<NotificationChildModel> notificationChildModelList;

    public NotificationsChildAdapter(List<NotificationChildModel> notificationChildModelList) {
        this.notificationChildModelList = notificationChildModelList;
    }

    @NonNull
    @Override
    public NotificationsChildAdapter.NotificationsChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_card_design, parent, false);
        return new NotificationsChildAdapter.NotificationsChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationsChildAdapter.NotificationsChildViewHolder holder, int position) {
        NotificationChildModel childModel = notificationChildModelList.get(position);
        holder.notificationTitle.setText(childModel.getTitle());
        holder.notificationDescription.setText(childModel.getDescription());
        holder.notificationTime.setText(childModel.getTime());
        holder.notificationTitle.setText(childModel.getTitle());
        holder.notificationIcon.setImageResource(childModel.getIcon());
    }

    @Override
    public int getItemCount() {
        return notificationChildModelList.size();
    }

    public class NotificationsChildViewHolder extends RecyclerView.ViewHolder {

        ImageView notificationIcon;
        TextView notificationTitle, notificationDescription, notificationTime;
        public NotificationsChildViewHolder(@NonNull View itemView) {
            super(itemView);

            notificationTitle = itemView.findViewById(R.id.notificationTitle);
            notificationDescription = itemView.findViewById(R.id.notificationDescription);
            notificationTime = itemView.findViewById(R.id.notificationTime);
            notificationIcon = itemView.findViewById(R.id.notificationIcon);
        }
    }
}
