package com.example.ravi.productapp;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ravi on 3/11/17.
 */

public class RecyclerAdpter extends RecyclerView.Adapter<RecyclerAdpter.DataViwholder> {

    ArrayList<Data> marrlist;




    public interface OnselectedLisner
    {
        public void onselected(Data data);

    }

    OnselectedLisner onselectedLisner;
    public void setOnselectedLisner(OnselectedLisner onselectedLisner)
    {
        this.onselectedLisner = onselectedLisner;
    }


    public RecyclerAdpter(ArrayList<Data> marrlist) {
       this.marrlist = marrlist;
   }

    @Override
    public DataViwholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_layout,null,false);

        return new DataViwholder(view);
    }

    @Override
    public void onBindViewHolder(DataViwholder holder, int position) {

         Data data = marrlist.get(position);

        holder.mProductname.setText(data.getName());
        holder.img.setImageResource(data.getImg());
        holder.mProductPrice.setText(data.getPrice());


    }

    @Override
    public int getItemCount() {
        return marrlist.size();
    }

    class DataViwholder extends RecyclerView.ViewHolder
    {

        TextView mProductname,mProductPrice;
        ImageView img;

        public DataViwholder(View itemView) {
            super(itemView);
            mProductname = itemView.findViewById(R.id.xtxtName);
            mProductPrice = itemView.findViewById(R.id.xtxtPrice);
            img = itemView.findViewById(R.id.img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onselectedLisner !=null)

                    {
                        int index = getAdapterPosition();
                        Data data = marrlist.get(getAdapterPosition());
                        data.index = getAdapterPosition();
                        onselectedLisner.onselected(data);
                    }
                }
            });


        }
    }


}
