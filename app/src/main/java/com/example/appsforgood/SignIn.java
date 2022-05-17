package com.example.appsforgood;

import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn extends AppCompatActivity {
    private FirebaseAuth signInAuth;
    private static final String TAG = "Sign In";


    private EditText username;
    private EditText password;
    private Button signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //Initializing the firebase and variables
        signInAuth = FirebaseAuth.getInstance();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username = (EditText)findViewById(R.id.editEmailAdressTextStr);
        password = (EditText)findViewById(R.id.editTextTextPassword);
        signInButton = (Button)findViewById(R.id.signInButtonStr);

    /*When the sign in button is clicked, the "signIn" method is called with the entered username
    [email] and password from their given text fields
     */
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                signIn(username.getText().toString(), password.getText().toString());
            }
        });
    }

    //the "signIn" method takes in two strings and uses them to create a firebase account
    private void signIn(String email, String password) {
        // [START sign_in_with_email]
        signInAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = signInAuth.getCurrentUser();
                            updateUI(user);

                            Intent intent = new Intent(SignIn.this, Prob_List.class);
                            startActivity(intent);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignIn.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END sign_in_with_email]
    }

    private void updateUI(FirebaseUser user){

    }

    //Once clicked, the exit button sends the user back to the welcome screen.
    public void clickExit(View v) {
        Toast toast = Toast.makeText(getApplicationContext(), "Hello, you clicked the Exit Button", Toast.LENGTH_LONG);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra("HelloStr", "Hello");
        startActivity(intent);

    }
}
