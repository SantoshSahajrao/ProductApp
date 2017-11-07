package com.example.ravi.productapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

/**
 * Created by ravi on 5/11/17.
 */

public class AddFrag extends Fragment {


    EditText proname,proprice,prodes;
    ImageView img;
    Button SaveBtn;
    int imgId;

    AddDataLisner addDataLisner;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.add_frag_layout,container,false);
        proname = view.findViewById(R.id.addEdtname);
        proprice = view.findViewById(R.id.addEdtprice);
        prodes = view.findViewById(R.id.addEdtDes);
        img = view.findViewById(R.id.addImg);
        SaveBtn = view.findViewById(R.id.addBtnSave);

        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Data data = new Data(proname.getText().toString(),proprice.getText().toString(),prodes.getText().toString(),imgId);
               addDataLisner.AddData(data);
               getFragmentManager().beginTransaction().remove(AddFrag.this).commit();


            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Images images = new Images();
                images.setNewImageLisner(new ImagSelced());
                getFragmentManager().beginTransaction().add(R.id.mainlayout,images,null).commit();


            }
        });

        return  view;

    }



    interface AddDataLisner
    {
        public void AddData(Data data);

    }

    public void setAddDataLisner(AddDataLisner addDataLisner)
    {
        this.addDataLisner = addDataLisner;


    }


    class ImagSelced implements Images.NewImageLisner
    {

        @Override
        public void newImage(int i) {
            imgId = i;

            img.setImageResource(imgId);
        }
    }
}
