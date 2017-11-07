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
import android.widget.TextView;

/**
 * Created by ravi on 6/11/17.
 */

public class Edit extends Fragment {

    EditText proname,proprice,prodes;
    ImageView img;
    Button btnSave;
    int imgId;
    Data data;

    EditDataLisner editDataLisner;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.edit_layout,container,false);
        proname = view.findViewById(R.id.edtEdtname);
        proprice = view.findViewById(R.id.edtEdtprice);
        prodes = view.findViewById(R.id.edtEdtDes);
        img = view.findViewById(R.id.edtImg);
        btnSave = view.findViewById(R.id.edtBtnSave);

        setData(data);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Data data = new Data(proname.getText().toString(),proprice.getText().toString(),prodes.getText().toString(),imgId);
                editDataLisner.setEditData(data);
                getFragmentManager().beginTransaction().remove(Edit.this).commit();

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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null)
        {

            data = (Data) bundle.getSerializable("Re");
        }
    }

    public  void setData(Data data)
{

    proname.setText(data.getName());
    proprice.setText(data.getPrice());
    prodes.setText(data.getDescription());
    img.setImageResource(data.getImg());
}


    class ImagSelced implements Images.NewImageLisner
    {

        @Override
        public void newImage(int i) {
            imgId = i;

            img.setImageResource(imgId);
        }
    }

    interface EditDataLisner
    {
        public  void  setEditData(Data data);
    }

    public  void setEditData(EditDataLisner editDataLisner)
    {
        this.editDataLisner = editDataLisner;
    }

}
