package com.example.appsforgood;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountActivity extends AppCompatActivity {
    //creating the account with firebase
    private FirebaseAuth fbAuth;
    private static final String TAG = "Sign Up";

    private EditText username;
    private EditText password;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        // Initialize Firebase Auth
        fbAuth = FirebaseAuth.getInstance();

        username = (EditText)findViewById(R.id.enterEmailSignUp);
        password = (EditText)findViewById(R.id.editTextTextPassword2);
        signUp = (Button)findViewById(R.id.signUpWithButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                onSignUpClick(username.getText().toString(), password.getText().toString());
            }
        });
        }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = fbAuth.getCurrentUser();
        if(currentUser != null){
            reload();
        }
    }

    private void reload(){

    }

    private void updateUI(FirebaseUser user){

    }

    public void onSignUpClick(String inputUsername, String inputPassword){
            fbAuth.createUserWithEmailAndPassword(inputUsername, inputPassword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");
                        FirebaseUser user = fbAuth.getCurrentUser();
                        updateUI(user);
                        Intent intent = new Intent(AccountActivity.this, Prob_List.class);
                        startActivity(intent);
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(AccountActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                }
            });
    }


    public void clickExit(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Exit Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }

}