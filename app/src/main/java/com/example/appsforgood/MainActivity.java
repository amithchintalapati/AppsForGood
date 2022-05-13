package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }


    public void clickSignUp(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Sign Up Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, AccountActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }

    public void clickSignIn(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Sign In Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, SignIn.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }
}