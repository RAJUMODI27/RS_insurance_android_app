package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> userList;

    // Constructor to pass the list of users
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each row of the RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        // Bind data to the view elements
        User user = userList.get(position);
        holder.usernameTextView.setText("Username: " + user.getUsername());
        holder.policyNoTextView.setText("Policy No: " + user.getPolicyNumber());
        holder.statusTextView.setText("Status: " + user.getStatus());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    // ViewHolder class to hold the views for each row
    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTextView, policyNoTextView, statusTextView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTextView = itemView.findViewById(R.id.usernameTextView);
            policyNoTextView = itemView.findViewById(R.id.policyNoTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
        }
    }
}
