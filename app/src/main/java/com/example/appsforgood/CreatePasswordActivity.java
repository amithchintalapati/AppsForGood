package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CreatePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);
    }

    public void clickConfirm(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Confirm Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainScreen.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }
    public void clickExit(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Exit Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, AccountActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }
}