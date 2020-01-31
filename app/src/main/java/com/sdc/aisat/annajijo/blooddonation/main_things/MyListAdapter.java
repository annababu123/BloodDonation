package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.my_class.PostRecord;
import com.google.firebase.database.FirebaseDatabase;
import com.sdc.aisat.annajijo.blooddonation.my_class.PostRecord;

import java.util.ArrayList;

/**
 * Created by Anna babu on 14/10/2017.
 */
public class MyListAdapter extends BaseAdapter{


    ArrayList<PostRecord> arrayList;
    LayoutInflater inflater;

    TextView name, unit, hospitalrelation,urgent,phone, info, volunteer;

    Button voll;


    int volll;

    Context context;
    public MyListAdapter(ArrayList<PostRecord> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }



    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {


        final int temp = i;

        view = inflater.from(context).inflate(R.layout.post_feed_list,parent,false);

        name = (TextView) view.findViewById(R.id.nameeeeeee);

        unit = (TextView) view.findViewById(R.id.units);

        hospitalrelation = (TextView) view.findViewById(R.id.hospitalrelation);

        urgent = (TextView) view.findViewById(R.id.urgent);

        phone = (TextView) view.findViewById(R.id.phone);

        info = (TextView) view.findViewById(R.id.instruction);

        volunteer = (TextView) view.findViewById(R.id.volunteer);

        name.setText("Donate Blood!!");

        unit.setText(arrayList.get(i).getUnits()+" of "+arrayList.get(i).getBlood() +" is required");

        hospitalrelation.setText("At "+arrayList.get(i).getHospital()+" for my "+arrayList.get(i).getRelation());

        urgent.setText(arrayList.get(i).getUrgency());

        phone.setText("Contact at: "+arrayList.get(i).getContact());

        info.setText(arrayList.get(i).getInfo());

        volunteer.setText("Volunteers uptil now: " +arrayList.get(i).getVolunteer());


        voll = (Button) view.findViewById(R.id.vol);


        volll = arrayList.get(i).getVolunteer();

        view.findViewById(R.id.volunteer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {







            }
        });

        if(arrayList.get(i).getVolunteer() == 0){




        }

        voll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                volll++;

                FirebaseDatabase.getInstance().getReference().child("Posting").child(arrayList.get(temp).getPush()).child("volunteer").setValue(volll);


            }
        });

        view.findViewById(R.id.comment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        TextView name, unit, hospitalrelation,urgent,phone, info, volunteer;


        return view;
    }
}
