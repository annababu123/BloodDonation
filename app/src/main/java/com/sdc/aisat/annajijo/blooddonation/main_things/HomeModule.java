package com.sdc.aisat.annajijo.blooddonation.main_things;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.sdc.aisat.annajijo.blooddonation.MainActivity;
import com.sdc.aisat.annajijo.blooddonation.R;
import com.sdc.aisat.annajijo.blooddonation.StaticClass;
import com.sdc.aisat.annajijo.blooddonation.main_things.HomePage;
import com.sdc.aisat.annajijo.blooddonation.main_things.ModulePage;
import com.sdc.aisat.annajijo.blooddonation.main_things.MyRequestPage;
import com.sdc.aisat.annajijo.blooddonation.main_things.NotificationPage;
import com.sdc.aisat.annajijo.blooddonation.main_things.PostBloodRequirment;
import com.sdc.aisat.annajijo.blooddonation.main_things.SettingPage;
import com.sdc.aisat.annajijo.blooddonation.my_class.PersonalRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;




public class HomeModule extends ActionBarActivity {

    TextView name, email;
    Button donor_button,request_button,notification_button,blood_bank;

    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> arrayList;
    ListView listView;
    PersonalRecord personalRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_module);

        name = (TextView) findViewById(R.id.nameIdd);
        email = (TextView) findViewById(R.id.emailIdd);
        donor_button = (Button) findViewById(R.id.donor_search);
        request_button = (Button) findViewById(R.id.request_button);
        notification_button = (Button) findViewById(R.id.notification_button);
        blood_bank = (Button) findViewById(R.id.blood_banks);



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

        donor_button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(HomeModule.this, DonorPage.class));
            }
        });

        request_button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(HomeModule.this, PostBloodRequirment.class));
            }
        });

        notification_button.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(HomeModule.this, HomePage.class));
            }
        });
        blood_bank.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(HomeModule.this, SettingPage.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.logout:
                //logout code
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, MainActivity.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();

    }
}

