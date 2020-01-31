package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.sdc.aisat.annajijo.blooddonation.MainActivity;
import com.sdc.aisat.annajijo.blooddonation.R;

import com.google.firebase.database.FirebaseDatabase;

import com.sdc.aisat.annajijo.blooddonation.my_class.PersonalRecord;


import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by AnnaJijo on 10/21/2017.
 */

public class DonorListAdapter extends BaseAdapter {

    ArrayList<PersonalRecord> arrayList;
    LayoutInflater inflater;

    TextView name, mail_id, bloodgroup, urgent, phone, info, volunteer;
    ImageButton callBtn;

    Button voll;


    int volll;

    Context context;

    public DonorListAdapter(ArrayList<PersonalRecord> arrayList, Context context) {
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

        view = inflater.from(context).inflate(R.layout.personal_feed, parent, false);

        name = (TextView) view.findViewById(R.id.name);

        mail_id = (TextView) view.findViewById(R.id.mailid);

        bloodgroup = (TextView) view.findViewById(R.id.bloodgroup);

        //urgent = (TextView) view.findViewById(R.id.urgent);

        phone = (TextView) view.findViewById(R.id.phone);
        callBtn = (ImageButton) view.findViewById(R.id.phoneImg);


        //volunteer = (TextView) view.findViewById(R.id.volunteer);

        name.setText(arrayList.get(i).getFirstName() + " " + arrayList.get(i).getLastName());
        bloodgroup.setText(arrayList.get(i).getBloodGroup());
        mail_id.setText(arrayList.get(i).getEmail());
        phone.setText("8281740237");

        //Performing action on button click
        callBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String number = phone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + number));
                context.startActivity(callIntent);

            }

        });








        return view;
    }
}
































