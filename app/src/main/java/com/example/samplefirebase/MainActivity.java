package com.example.samplefirebase;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity{

    private DatabaseReference firebaseDatabase;
    private FirebaseDatabase firebaseInstance;
    private String UserId;

    EditText idno, lname, fname;
    Button add, update, delete, view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///
        idno = (EditText) findViewById(R.id.idnumber);
        lname = (EditText) findViewById(R.id.lname);
        fname = (EditText) findViewById(R.id.fname);

        add = (Button) findViewById(R.id.addbtn);
        update = (Button) findViewById(R.id.editbtn);
        delete = (Button) findViewById(R.id.delbtn);
        view = (Button) findViewById(R.id.viewbtn);


        firebaseInstance = FirebaseDatabase.getInstance();
        firebaseDatabase = firebaseInstance.getReference("DataUsers");
        UserId = firebaseDatabase.push().getKey();

//        add.setOnClickListener(this);
//        update.setOnClickListener(this);
//        delete.setOnClickListener(this);
//        view.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View v) {
//
//        switch (v.getId()){
//            case R.id.addbtn:
//                Toast.makeText(getApplicationContext(),"You have clicked add button", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.editbtn:
//                Toast.makeText(getApplicationContext(),"You have clicked edit button", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.delbtn:
//                Toast.makeText(getApplicationContext(),"You have clicked delete button", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.viewbtn:
//                Toast.makeText(getApplicationContext(),"You have clicked view button", Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }

    public void addUser (String idno, String lname, String fname){

        User users = new User(idno, lname, fname);
        firebaseDatabase.child("Users").child(UserId).setValue(users);
    }

    public void updateUser(String idno, String lname, String fname){
        firebaseDatabase.child("Users").child(UserId).child("idno").setValue(idno);
        firebaseDatabase.child("Users").child(UserId).child("lname").setValue(lname);
        firebaseDatabase.child("Users").child(UserId).child("fname").setValue(fname);
    }

    public void insertData(View view){
        addUser(idno.getText().toString().trim(), lname.getText().toString().trim(), fname.getText().toString().trim());
        Toast.makeText(getApplicationContext(),"Successfully inserted!", Toast.LENGTH_SHORT).show();
    }

    public void updateData(View view){
        updateUser(idno.getText().toString().trim(), lname.getText().toString().trim(), fname.getText().toString().trim());
    }

    public void viewData(View view){
        firebaseDatabase.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren()){
                    String dbidno = ds.child("idno").getValue(String.class);
                    String dblname = ds.child("lname").getValue(String.class);
                    String dbfname = ds.child("fname").getValue(String.class);
                    Log.d("TAG", dbidno + "/" + dblname + "/" + dbfname);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
