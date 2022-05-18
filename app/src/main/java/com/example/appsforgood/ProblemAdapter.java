package com.example.appsforgood;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentReference;


public class ProblemAdapter extends FirestoreRecyclerAdapter<Problem, ProblemAdapter.ProblemHolder> {

    public ProblemAdapter(@NonNull FirestoreRecyclerOptions<Problem> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ProblemHolder holder, int position, @NonNull Problem model) {
        // Sets all the values to the holder
        holder.textViewTask.setText(model.getTask());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewPriority.setText(String.valueOf(model.getPriority()));
        holder.textViewContactInformation.setText(String.valueOf(model.getContactInformation()));

    }

    // Accesses card xml to format all of the values
    @NonNull
    @Override
    public ProblemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.prob_item,
                parent, false);
        return new ProblemHolder(v);
    }

    public void deleteItem(int position) {
        getSnapshots().getSnapshot(position).getReference().delete();
    }

    // Tasks are set to the recycler view
    public class ProblemHolder extends RecyclerView.ViewHolder {
        TextView textViewTask;
        TextView textViewDescription;
        TextView textViewPriority;
        TextView textViewContactInformation;


        public ProblemHolder(View itemView) {
            super(itemView);
            textViewTask = itemView.findViewById(R.id.text_view_task);
            textViewDescription = itemView.findViewById(R.id.text_view_description);
            textViewPriority = itemView.findViewById(R.id.text_view_priority);
            textViewContactInformation = itemView.findViewById(R.id.text_view_contact_information);

        }
    }
}
