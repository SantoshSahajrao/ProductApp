package com.example.ravi.productapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by ravi on 6/11/17.
 */

public class ImgAdpter extends RecyclerView.Adapter<ImgAdpter.ImagViewholder>{

    int Img[];
    ImageCliclistner imageCliclistner;


    public ImgAdpter(int[] img) {
        Img = img;
    }

    @Override
    public ImagViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imgadpteer_layout,null,false);

        return new ImagViewholder(view);
    }

    @Override
    public void onBindViewHolder(ImagViewholder holder, int position) {

        holder.imageView.setImageResource(Img[position]);

    }

    @Override
    public int getItemCount() {
        return Img.length;
    }

    class ImagViewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;


        public ImagViewholder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Imgid);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int imgId = Img[getAdapterPosition()];
                    if (imageCliclistner != null)
                    {
                        imageCliclistner.ImageSelcetd(imgId);
                    }
                }
            });
        }
    }


    interface ImageCliclistner
    {
        public void ImageSelcetd(int i);
    }
    public  void setImageCliclistner(ImageCliclistner imageCliclistner)
    {

        this.imageCliclistner = imageCliclistner;
    }
}
