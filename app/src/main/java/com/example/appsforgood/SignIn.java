package com.example.appsforgood;

import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
    public void clickActualSignIn(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Sign In Numero Dos Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainScreen.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);
    }
    public void clickExit(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Exit Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }
}
