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
        setContentView(R.layout.activity_main);
    }

    public void clickSignUp(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Sign Up Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, SignUpActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }

}