package com.example.ravi.productapp;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ravi on 3/11/17.
 */

public class Mainpage extends Fragment{

    RecyclerView recyclerView;
    ArrayList<Data> mArrlist;
    RecyclerAdpter recyclerAdpter;
    Data mydata;
    Communicator communicator;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mArrlist = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       if (savedInstanceState !=null)
       {
            mArrlist = (ArrayList<Data>) savedInstanceState.getSerializable("Data");
       }


        View view = inflater.inflate(R.layout.mainpage_layout,container,false);
        recyclerView = view.findViewById(R.id.xRecy);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        mArrlist.add(new Data("Apple","200","fruit",R.drawable.apple));
        mArrlist.add(new Data("Anjeer","250","fruit",R.drawable.anjeer));
        recyclerAdpter = new RecyclerAdpter(mArrlist);

        recyclerAdpter.setOnselectedLisner(new Abc());


        recyclerView.setAdapter(recyclerAdpter);







        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("Data",mArrlist);
    }

    public void AddData(Data data)
    {
        recyclerAdpter.notifyDataSetChanged();
        mArrlist.add(data);
        recyclerAdpter.notifyDataSetChanged();
    }
    public void Editdata(Data data)
    {
        recyclerAdpter.notifyDataSetChanged();
        mArrlist.add(data.getIndex(),data);
        mArrlist.remove(data.getIndex()+1);
        recyclerAdpter.notifyDataSetChanged();

    }
    public void DeletData(Data data)
    {
        mArrlist.remove(data.getIndex());
        recyclerAdpter.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        communicator = (Communicator) getActivity();

    }



    class Abc implements RecyclerAdpter.OnselectedLisner
{

    @Override
    public void onselected(Data data) {
         mydata = data;

        if(communicator != null) {

            communicator.respond(mydata);

        }
        else
        {
            Toast.makeText(getActivity(), "Null", Toast.LENGTH_SHORT).show();
        }

    }
}


public interface Communicator
{
    public void respond(Data data);
}
public void setCommunicator(Communicator communicator1)
{
    communicator = communicator1;
}




}
