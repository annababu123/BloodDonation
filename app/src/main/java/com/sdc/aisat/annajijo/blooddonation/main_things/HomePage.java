package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.sdc.aisat.annajijo.blooddonation.MainActivity;
import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.my_class.PersonalRecord;
import com.sdc.aisat.annajijo.blooddonation.my_class.PostRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomePage extends HomeModule {


    //////////
    String stringUid;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    //////////

    //////////
    ListView postReadListView;
    PostRecord postRecord;
    ArrayList<PostRecord> arrayList;
///////////////


    FirebaseDatabase db;
    DatabaseReference ref;

    MyListAdapter listAdapter;

    PersonalRecord personalRecord;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listView = (ListView) findViewById(R.id.postReadListViewId);

        arrayList = new ArrayList<>();
//
        listAdapter = new MyListAdapter(arrayList,this);
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





        FirebaseDatabase.getInstance().getReference().child("Post").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                postRecord = dataSnapshot.getValue(PostRecord.class);

                Log.d("data", "onChildAdded: "+postRecord.getName());

                arrayList.add(postRecord);

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
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, HomeModule.class));
        finish();

    }

}
