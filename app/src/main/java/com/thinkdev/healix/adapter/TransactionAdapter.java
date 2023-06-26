package com.thinkdev.healix.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.R;
import com.thinkdev.healix.model.TransactionalModel;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<TransactionalModel> transactionalModelList;

    public TransactionAdapter(List<TransactionalModel> transactionalModelList) {
        this.transactionalModelList = transactionalModelList;
    }

    @NonNull
    @Override
    public TransactionAdapter.TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.transaction_group_card, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.TransactionViewHolder holder, int position) {
        TransactionalModel transactionalModel = transactionalModelList.get(position);
        holder.transactionDate.setText(transactionalModel.getDate());
        holder.transactionDay.setText(transactionalModel.getDay());
        holder.transactionMonth.setText(transactionalModel.getMonth());
        holder.transactionTotal.setText(transactionalModel.getAmount());

        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.transactionRecycler.getContext(), LinearLayoutManager.VERTICAL, false);

        layoutManager.setInitialPrefetchItemCount(transactionalModel.getChildItemList().size());

        TransactionChildAdapter transactionChildAdapter = new TransactionChildAdapter(transactionalModel.getChildItemList());
        holder.transactionRecycler.setLayoutManager(layoutManager);
        holder.transactionRecycler.setAdapter(transactionChildAdapter);
        holder.transactionRecycler.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return transactionalModelList.size();
    }

    public class TransactionViewHolder extends RecyclerView.ViewHolder {

        private TextView transactionDate, transactionDay, transactionMonth, transactionTotal;
        private RecyclerView transactionRecycler;
        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            transactionDate = itemView.findViewById(R.id.transactionDate);
            transactionDay = itemView.findViewById(R.id.transactionDay);
            transactionMonth = itemView.findViewById(R.id.transactionMonth);
            transactionTotal = itemView.findViewById(R.id.transactionAmount);
            transactionRecycler = (RecyclerView) itemView.findViewById(R.id.transaction_nested_recycler);
        }
    }
}
