package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prob_list);
        startActivity(new Intent(MainActivity.this, Prob_List.class));
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