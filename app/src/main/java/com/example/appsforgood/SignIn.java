package com.example.appsforgood;

import android.os.Bundle;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = (EditText)findViewById(R.id.editEmailAdressTextStr);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        signIn = (Button)findViewById(R.id.signInButtonStr);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                validate(username.getText().toString(), password.getText().toString());

            }
        });
    }

    private void validate (String userName, String userPassword){
        if((userName.equals("username")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(SignIn.this, MainScreen.class);
            startActivity(intent);
        }
        else{
            signIn.setEnabled(false);
        }
    }

    public void clickActualSignIn(View v) {

        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Sign In Numero Dos Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, Prob_List.class);
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