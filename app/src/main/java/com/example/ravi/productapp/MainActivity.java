package com.example.ravi.productapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Mainpage.Communicator,AddFrag.AddDataLisner,Edit.EditDataLisner {


    Data data;
    Mainpage f1 ;
    FragmentManager manager;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        f1 = new Mainpage();
        getSupportFragmentManager().beginTransaction().add(R.id.mainlayout,f1,null).commit();



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId()==R.id.addpro)
        {
          AddFrag  addFrag = new AddFrag();
          getSupportFragmentManager().beginTransaction().add(R.id.mainlayout,addFrag,null).addToBackStack(null).commit();

            addFrag.setAddDataLisner(this);
        }


        if (item.getItemId()==R.id.edtpro)
        {

            Edit edit = new Edit();
            Bundle bundle = new Bundle();
            bundle.putSerializable("Re",data);

            F2 f2 = (F2) manager.findFragmentByTag("F2");

            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.mainlayout,edit,null).remove(f2).commit();






            edit.setArguments(bundle);
            edit.setEditData(this);


        }
        if (item.getItemId() == R.id.deletepro)
        {
            f1.DeletData(data);
            F2 f2 = (F2) manager.findFragmentByTag("F2");
            getSupportFragmentManager().beginTransaction().remove(f2).commit();
        }


        return true;
    }

    @Override
    public void respond(Data data) {

        this.data = data;
        position = data.getIndex();

        F2 f2 = new F2();
        getSupportFragmentManager().beginTransaction().add(R.id.mainlayout,f2,"F2").addToBackStack(null).commit();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Re",data);
        f2.setArguments(bundle);




    }


    @Override
    public void onBackPressed() {

        int count = getSupportFragmentManager().getBackStackEntryCount();


        if (count!=0)

        {
            super.onBackPressed();


        }
        else
        {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit");
            builder.setMessage("Really Exit");
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }


    }

    @Override
    public void AddData(Data data) {

        this.data = data;
        f1.AddData(this.data);


    }


    @Override
    public void setEditData(Data data) {

        this.data = data;
       this.data.index = position;
        f1.Editdata(this.data);
    }
}
