package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.StaticClass;
import com.sdc.aisat.annajijo.blooddonation.my_class.PersonalRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ModulePage extends AppCompatActivity {

    TextView name, email;

    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;
    ListView listView;
    PersonalRecord personalRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_page);

        name = (TextView) findViewById(R.id.nameIdd);
        email = (TextView) findViewById(R.id.emailIdd);



        FirebaseDatabase.getInstance().getReference().child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                personalRecord = dataSnapshot.getValue(PersonalRecord.class);


                name.setText(personalRecord.getFirstName());

                email.setText(personalRecord.getEmail());

                StaticClass.personalRecord = personalRecord;
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


        arrayList = new ArrayList<>();

        listView = (ListView) findViewById(R.id.list_item);

        arrayList.add("Home");
        arrayList.add("My Requests");
        arrayList.add("Post Requirments");
        arrayList.add("Notification");
        arrayList.add("Setting");

        arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);

        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:
                        startActivity(new Intent(ModulePage.this, HomePage.class));

                        break;
                    case 1:
                        startActivity(new Intent(ModulePage.this, MyRequestPage.class));

                        break;

                    case 2:
                        startActivity(new Intent(ModulePage.this, PostBloodRequirment.class));

                        break;
                    case 3:
                        startActivity(new Intent(ModulePage.this, NotificationPage.class));

                        break;

                    case 4:
                        startActivity(new Intent(ModulePage.this, SettingPage.class));

                        break;


                }

            }
        });
    }
}
