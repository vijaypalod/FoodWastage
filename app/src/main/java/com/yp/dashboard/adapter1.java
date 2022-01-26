package com.yp.dashboard;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter1 extends RecyclerView.Adapter<adapter1.myviewholder1> {

    ArrayList<model1> model1s;
    Context context;

    public adapter1(ArrayList<model1> model1s, Context context) {

        this.model1s = model1s;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singlerow1,parent,false);
        return new myviewholder1(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder1 holder, int position) {
        final model1 m = model1s.get(position);
        holder.dName.setText(m.getName());
        holder.dEmail.setText(m.getEmail());
        holder.dMobile.setText(m.getMobile());
        holder.dAddress.setText(m.getAddress());
        holder.dDate.setText(m.getDate());
        holder.dFood.setText(m.getFood());
        holder.dQuantity.setText(m.getQuantity());

        holder.cardDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, m.getName()+"Will be Deleted", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation!!!");
                builder.setMessage("Are You Sure to delete" + m.getName()+"?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        DBHelper dbHelper = new DBHelper(context);
                        int result = dbHelper.deleteRequest(m.getId());

                        if(result>0){
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                            model1s.remove(m);
                            notifyDataSetChanged();
                        }else {
                            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("No",null);
                builder.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return model1s.size();
    }

    class myviewholder1 extends RecyclerView.ViewHolder{
        TextView dName,dEmail,dMobile,dAddress,dDate,dFood,dQuantity;
        CardView cardDelete;
        public myviewholder1(@NonNull View itemView) {
            super(itemView);
            dName = (TextView) itemView.findViewById(R.id.dispName);
            dEmail = (TextView) itemView.findViewById(R.id.dispEmail);
            dMobile = (TextView) itemView.findViewById(R.id.dispMobile);
            dAddress = (TextView) itemView.findViewById(R.id.dispAddress);
            dDate = (TextView) itemView.findViewById(R.id.dispDate);
            dFood = (TextView) itemView.findViewById(R.id.dispFood);
            dQuantity = (TextView) itemView.findViewById(R.id.dispQuant);

            cardDelete = itemView.findViewById(R.id.cardDelete);
        }
    }
}
