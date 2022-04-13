package com.example.appsforgood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    //Data
    Button changeTextButton;
    TextView wordChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void changesStatus(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Change Button", Toast.LENGTH_LONG);
        toast.show();
        wordChange = (TextView)findViewById(R.id.testingChangingStatusLabelStr);
        wordChange.setText("it changes lfg");
    }
    public void createTaskClick(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Create Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MakeProblem.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }

    public void clickTaskButton(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked a Task Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, ChooseToHelp.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }
    public void clickHomeButton(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked a Task Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }
}