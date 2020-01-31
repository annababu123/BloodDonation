package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sdc.aisat.annajijo.blooddonation.MainActivity;
import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.StaticClass;
import com.sdc.aisat.annajijo.blooddonation.my_class.PostRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class PostBloodRequirment extends HomeModule {

    //////////
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    ///////////
    Button postBtn;

    FirebaseDatabase db;
    DatabaseReference ref;

    PostRecord postRecord;

    String stringKeyPost, stringUidPost, stringBloodGroupPost, stringUnitsRequiredPost, stringUrgencyPost,
            stringCountryPost, stringStatePost, stringCityPost, stringHospitalPost, stringPatientRelationPost,
            stringContactPost, stringInstructionPost;

    EditText key, unitsRequiredET, contactNoET, instructionET;

    ArrayList<PostRecord> postRecordArrayList;


    ////////spinner/////
    Spinner dropdownOne, dropdownTwo, dropdownThree, dropdownFour, dropdownFive, dropdownSix , dropdownSeven;
    String stringDropdownValue;
    ///////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_blood_requirment);


        db = FirebaseDatabase.getInstance();
        ref = db.getReference("Post");


        /////////
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        if (firebaseAuth.getCurrentUser() == null){

            // startActivity(new Intent(this, Login.class));
        }else {
            stringUidPost = firebaseUser.getUid();//
        }

        ///////////


        postRecordArrayList = new ArrayList<>();


//////////////////////
        unitsRequiredET = (EditText) findViewById(R.id.unitsRequiredEtId);

        contactNoET = (EditText) findViewById(R.id.contactnoEtId);

        instructionET = (EditText) findViewById(R.id.instructionEtId);
/////////////////////////////


        ////////spiner one///////
        dropdownOne = (Spinner)findViewById(R.id.spinnerBloodGroupId);
        String[] itemsOne = new String[]{"A +", "A-", "B+", "B-", "O+", "O-"};
        ArrayAdapter<String> adapterOne = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsOne);
        dropdownOne.setAdapter(adapterOne);

        dropdownOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringBloodGroupPost = dropdownOne.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////


        ////////spiner two///////
        dropdownTwo = (Spinner)findViewById(R.id.spinnerUrgencyId);
        String[] itemsTwo = new String[]{"Urgent", " Within 5 hours", "Within 12 hours", "Within 24 hours", " Within 2 days", "Within Week"};
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsTwo);
        dropdownTwo.setAdapter(adapterTwo);

        dropdownTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringUrgencyPost = dropdownTwo.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////


        ////////spiner Three///////
        dropdownThree = (Spinner)findViewById(R.id.spinnerCountryId);
        String[] itemsThree = new String[]{"India", "America","Sreelanka","China"};
        ArrayAdapter<String> adapterThree = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsThree);
        dropdownThree.setAdapter(adapterThree);

        dropdownThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringCountryPost = dropdownThree.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////


        ////////spiner Four///////
        dropdownFour = (Spinner)findViewById(R.id.spinnerStateId);
        String[] itemsFour = new String[]{"Kerala","Karnataka", "TamilNadu","AndhraPradhesh","Maharastra","Gujarat"};
        ArrayAdapter<String> adapterFour = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsFour);
        dropdownFour.setAdapter(adapterFour);

        dropdownFour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringStatePost = dropdownFour.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////



        ////////spiner Five///////
        dropdownFive = (Spinner)findViewById(R.id.spinnerCityId);
        String[] itemsFive = new String[]{"Ernakulam","Thrissur", "Calicut","Kollam"};
        ArrayAdapter<String> adapterFive = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsFive);
        dropdownFive.setAdapter(adapterFive);

        dropdownFive.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringCityPost = dropdownFive.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////


        ////////spiner Six///////
        dropdownSix = (Spinner)findViewById(R.id.spinnerHospitalId);
        String[] itemsSix = new String[]{" Lakeshore Hospital","Sunrise Hospital", "MAJ Hospital","Amrita Hospital", "Holy Family Hospital","Little Flower Hospital"};
        ArrayAdapter<String> adapterSix = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsSix);
        dropdownSix.setAdapter(adapterSix);

        dropdownSix.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringHospitalPost = dropdownSix.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////



        ////////spiner Seven///////
        dropdownSeven = (Spinner)findViewById(R.id.spinnerPatientRelationId);
        String[] itemsSeven = new String[]{"Father"," Mother", "Son","Daughter",
                "Aunt", "Uncle", "Nephew", "Niece", "Friend", "Neighbour", "None"};
        ArrayAdapter<String> adapterSeven = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsSeven);
        dropdownSeven.setAdapter(adapterSeven);

        dropdownSeven.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                stringPatientRelationPost = dropdownSeven.getItemAtPosition(position).toString();
                Log.v("item", (String) parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
        //  stringDropdownValue = dropdown.getSelectedItem().toString();
        //////////spiner/////////



        postBtn = (Button) findViewById(R.id.postBtnId);
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //////////
                stringUnitsRequiredPost = unitsRequiredET.getText().toString().trim();
                stringContactPost = contactNoET.getText().toString().trim();
                stringInstructionPost = instructionET.getText().toString().trim();
                //////////

/////////////insert//////////String name, String email, String currentgrp, String uid, String push, int units, String blood, String urgency, String country, String state, String city, String hospital, String relation, String contact, String info,int volunteer
                postRecord = new PostRecord(StaticClass.personalRecord.getFirstName(),StaticClass.personalRecord.getEmail(),StaticClass.personalRecord.getBloodGroup(),FirebaseAuth.getInstance().getCurrentUser().getUid(),FirebaseDatabase.getInstance().getReference().child("Post").push().getKey(),Integer.parseInt( stringUnitsRequiredPost),stringBloodGroupPost,stringUrgencyPost,stringCountryPost,stringStatePost,stringCityPost,stringHospitalPost,stringPatientRelationPost,stringContactPost,"no",0);

                FirebaseDatabase.getInstance().getReference().child("Post").child(postRecord.getPush()).setValue(postRecord);


                Toast.makeText(PostBloodRequirment.this, "Posted", Toast.LENGTH_SHORT).show();

//                ref.child(stringUidPost).setValue(postRecord);
/////////////insert/////////////

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
