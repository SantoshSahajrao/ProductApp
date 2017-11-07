package com.example.ravi.productapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ravi on 6/11/17.
 */

public class Images extends Fragment implements ImgAdpter.ImageCliclistner{

    RecyclerView mrecyclerView;
    int Img[] = {R.drawable.anjeer,R.drawable.apple,R.drawable.banana,R.drawable.orange,R.drawable.strwberry};
    ImgAdpter mimgAdpter;

    int Imageselcted;

    NewImageLisner newImageLisner;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.img_layout,container,false);

        mrecyclerView = view.findViewById(R.id.imgrey);
        mimgAdpter = new ImgAdpter(Img);

        mrecyclerView.setAdapter(mimgAdpter);

        mrecyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        mimgAdpter.setImageCliclistner(this);



        return view;
    }

    @Override
    public void ImageSelcetd(int i) {
        Imageselcted = i;
        if (newImageLisner != null)
        {
            newImageLisner.newImage(Imageselcted);

            getFragmentManager().beginTransaction().remove(Images.this).commit();
        }
    }

    interface NewImageLisner
    {
        public void newImage(int i);

    }

    public  void setNewImageLisner(NewImageLisner newImageLisner)
    {
        this.newImageLisner =newImageLisner;

    }
}
