package com.example.samplefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText idno, lname, fname;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///
        idno = (EditText) findViewById(R.id.idnumber);
        lname = (EditText) findViewById(R.id.lname);
        fname = (EditText) findViewById(R.id.fname);
        send = (Button) findViewById(R.id.sendbtn);

        send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Information successfully sent!", Toast.LENGTH_SHORT).show();
    }
}
