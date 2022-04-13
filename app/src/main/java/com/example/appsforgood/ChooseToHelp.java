package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseToHelp extends AppCompatActivity {

    //Data
    TextView wordChange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_to_help);
    }

    public void clickExit(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Exit Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainScreen.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }

    //Text change not working yet. Only works with same screen button and text
    public void clickChooseToHelp(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the \"Choose to Help\" Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainScreen.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
        wordChange = (TextView)findViewById(R.id.testingChangingStatusLabelStr);
        wordChange.setText("it changes");
    }
}