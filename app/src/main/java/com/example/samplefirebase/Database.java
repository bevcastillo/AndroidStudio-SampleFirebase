package com.example.samplefirebase;

import com.firebase.client.Firebase;
import com.google.firebase.FirebaseApp;

public class Database extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
