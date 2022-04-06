package com.example.appsforgood;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    private void toPwScreen() {
        Toast toast = Toast.makeText(getApplicationContext(), "Moving to create password screen", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, CreatePasswordActivity.class);
        startActivity(intent);
    }

}