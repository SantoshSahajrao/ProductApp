package com.example.ravi.productapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ravi on 3/11/17.
 */

public class F2  extends Fragment
{

    ImageView imageView;
    TextView proname,proprice,prodes;
    Data data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.f2_layout,container,false);
        imageView = view.findViewById(R.id.detailImg);
        proname =view.findViewById(R.id.deatilName);
        proprice = view.findViewById(R.id.deatilPrice);
        prodes = view.findViewById(R.id.deatilDescritipn);

        setData(data);

        Toast.makeText(getActivity(), "Oncreat", Toast.LENGTH_SHORT).show();

        return view;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle !=null)
        {
            data = (Data) bundle.getSerializable("Re");


        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }

    public void setData(Data data)
    {
        proname.setText(data.getName());
        proprice.setText(data.getPrice());
        prodes.setText(data.getDescription());
        imageView.setImageResource(data.getImg());

    }



}
