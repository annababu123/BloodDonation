package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sdc.aisat.annajijo.blooddonation.MainActivity;
import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.my_class.PersonalRecord;

import java.util.ArrayList;

public class DonorPage extends HomeModule {
    String stringUid;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    //////////

    //////////
    ListView postReadListView;
    PersonalRecord postRecord;
    ArrayList<PersonalRecord> arrayList;
///////////////

    Spinner bloodgroupDropdown;
    String stringDropdownValue;



    FirebaseDatabase db;
    DatabaseReference ref;

    DonorListAdapter listAdapter;

    PersonalRecord personalRecord;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_page);
        listView = (ListView) findViewById(R.id.donorList);

        arrayList = new ArrayList<>();
//
        listAdapter = new DonorListAdapter(arrayList,this);
//
        listView.setAdapter(listAdapter);
//

        /////////
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseAuth.getCurrentUser() == null){

            // startActivity(new Intent(this, Login.class));
        }else {
            stringUid = firebaseUser.getUid();//
        }

        ////////spiner///////
        bloodgroupDropdown = (Spinner)findViewById(R.id.bloodgroupspinner);
        String[] items = new String[]{"A +", "A-", "B+", "B-", "O+", "O-"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        bloodgroupDropdown.setAdapter(adapter);

        bloodgroupDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                arrayList.clear();
                stringDropdownValue = bloodgroupDropdown.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));

                FirebaseDatabase.getInstance().getReference().child("users").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        personalRecord = (PersonalRecord) dataSnapshot.child("data").getValue(PersonalRecord.class);
                        Log.d("data", "onChildAdded: " + personalRecord.getBloodGroup());
                        if (personalRecord.getBloodGroup().equals(stringDropdownValue)) {
                            Log.d("data", "onChildAdded: " + personalRecord.getFirstName());

                            arrayList.add(personalRecord);
                        }else{
                            //arrayList.add(personalRecord);
                        }

                        listAdapter.notifyDataSetChanged();



                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });




    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, HomeModule.class));
        finish();

    }

}
