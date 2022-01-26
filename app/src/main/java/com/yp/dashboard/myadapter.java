package com.yp.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {

    ArrayList<model> dataholder;

    public myadapter(ArrayList<model> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.dName.setText(dataholder.get(position).getName());
        holder.dEmail.setText(dataholder.get(position).getEmail());
        holder.dMobile.setText(dataholder.get(position).getMobile());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        TextView dName,dEmail,dMobile;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            dName = (TextView) itemView.findViewById(R.id.dispName);
            dEmail = (TextView) itemView.findViewById(R.id.dispEmail);
            dMobile = (TextView) itemView.findViewById(R.id.dispMobile);
        }
    }
}
