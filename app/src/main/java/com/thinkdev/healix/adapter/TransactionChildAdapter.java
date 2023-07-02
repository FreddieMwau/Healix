package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.interfaces.TransactionInterface;
import com.thinkdev.healix.model.TransactionChildModel;

import java.util.List;

public class TransactionChildAdapter extends RecyclerView.Adapter<TransactionChildAdapter.TransactionChildViewHolder> {

    private List<TransactionChildModel> childModelList;
    private TransactionInterface transactionInterface;

    public TransactionChildAdapter(List<TransactionChildModel> childModelList) {
        this.childModelList = childModelList;
    }

    @NonNull
    @Override
    public TransactionChildAdapter.TransactionChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_card_design, parent, false);
        return new TransactionChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionChildAdapter.TransactionChildViewHolder holder, int position) {
        TransactionChildModel transactionChildModel = childModelList.get(position);
        holder.title.setText(transactionChildModel.getTitle());
        holder.description.setText(transactionChildModel.getDescription());
        holder.time.setText(transactionChildModel.getTime());
        holder.progress.setProgress(transactionChildModel.getPercentage());
        holder.icon.setImageResource(transactionChildModel.getIcon());
    }

    @Override
    public int getItemCount() {
        return childModelList.size();
    }

    public void setOnItemClickListener(TransactionInterface transactionInterface) {
        this.transactionInterface = transactionInterface;
    }

    public class TransactionChildViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView icon;
        TextView title, description, time;
        ProgressBar progress;
        public TransactionChildViewHolder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.paymentIcon);
            title = itemView.findViewById(R.id.paymentTitle);
            description = itemView.findViewById(R.id.paymentDescription);
            time = itemView.findViewById(R.id.paymentTime);
            progress = itemView.findViewById(R.id.paymentProgressBar);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (transactionInterface != null){
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION){
                    transactionInterface.onItemClicked(pos);
                }
            }
        }
    }
}
