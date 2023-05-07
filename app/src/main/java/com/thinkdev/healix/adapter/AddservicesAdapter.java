package com.thinkdev.healix.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.thinkdev.healix.activity.DailogeActivity;
import com.thinkdev.healix.R;
import com.thinkdev.healix.model.AddServicesData;

import java.util.List;

public class AddservicesAdapter extends RecyclerView.Adapter<AddservicesAdapter.ViewHolder>{
    private List<AddServicesData> listdata;

    // RecyclerView recyclerView;
    private Context mcontext;

    // RecyclerView recyclerView;
    public AddservicesAdapter(Context mcontext, List<AddServicesData> listdata) {
        this.listdata = listdata;
        this.mcontext = mcontext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.item_additem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTv.setText(listdata.get(position).getNameTv());
        holder.subnameTv.setText(listdata.get(position).getSubnameTv());
        holder.totalvalueTv.setText(listdata.get(position).getPaytotal());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mcontext, DailogeActivity.class);

                mcontext.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public AppCompatButton btn;
        public TextView totalvalueTv,nameTv,subnameTv,invDate,desTv;

        public ViewHolder(View itemView) {
            super(itemView);
            this.nameTv = (TextView) itemView.findViewById(R.id.namePa);
            this.subnameTv = (TextView) itemView.findViewById(R.id.consTv);
            this.totalvalueTv = (TextView) itemView.findViewById(R.id.totalvalueTv);

        }
    }
}