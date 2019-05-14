package com.example.samplefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText idno, lname, fname;
    Button add, update, delete, view;
    Firebase firebaseReference;

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


        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.addbtn:
                Toast.makeText(getApplicationContext(),"You have clicked add button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.editbtn:
                Toast.makeText(getApplicationContext(),"You have clicked edit button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delbtn:
                Toast.makeText(getApplicationContext(),"You have clicked delete button", Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewbtn:
                Toast.makeText(getApplicationContext(),"You have clicked view button", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
