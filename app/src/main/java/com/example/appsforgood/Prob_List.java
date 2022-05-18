package com.example.appsforgood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class Prob_List extends AppCompatActivity {

    // Firestore was used because of its offline synchronization and easy integration with the database
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference problemsRef = db.collection("Problems");

    private ProblemAdapter adapter;

    // Accesses the problem list activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prob_list);

        FloatingActionButton buttonAddProb = findViewById(R.id.button_add_prob);
        buttonAddProb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Prob_List.this, NewProbActivity.class));
            }
        });

        setUpRecyclerView();
    }

    // Recycler view orders by priority so that problems of the highest priority are shown at the top
    private void setUpRecyclerView() {
        Query query = problemsRef.orderBy("priority", Query.Direction.DESCENDING);
        //Query query = db.collection("Problems");

        FirestoreRecyclerOptions<Problem> options = new FirestoreRecyclerOptions.Builder<Problem>()
                .setQuery(query, Problem.class)
                .build();

        adapter = new ProblemAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.probListRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // Users can delete problems by swiping left or right on them in the problem list
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                adapter.deleteItem(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}