package com.example.appsforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewProbActivity extends AppCompatActivity {
    // Data fields from xml file
    private EditText editTextTask;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private EditText editTextContactInformation;

    // Accesses the New Problem xml file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_prob);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Problem");

        editTextTask = findViewById(R.id.edit_text_task);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        editTextContactInformation = findViewById(R.id.edit_text_contact_information);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(10);
    }

    // Accesses the new problem menu with save bar from menu directory
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.new_prob_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Makes sure saveNote can be clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.save_prob:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Assigns all the values when the new problem is saved
    private void saveNote() {
        String task = editTextTask.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();
        String contactInformation = editTextContactInformation.getText().toString();

        // Makes sure that the user didn't forget to assign any of the required fields
        if(task.trim().isEmpty() || description.trim().isEmpty() || contactInformation.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title, description, and contact information", Toast.LENGTH_SHORT).show();
            return;
        }

        // Lets the user know that their action was received
        CollectionReference probRef = FirebaseFirestore.getInstance()
                .collection("Problems");
        probRef.add(new Problem(task, description, priority, contactInformation));
        Toast.makeText(this, "Problem added", Toast.LENGTH_SHORT).show();
        finish();
    }

}