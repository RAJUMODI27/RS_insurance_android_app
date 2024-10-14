package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private DatabaseHelper databaseHelper;

    private EditText policyNoEditText, usernameEditText, statusEditText;
    private Button updateStatusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        // Initialize views
        recyclerView = findViewById(R.id.recyclerView);
        policyNoEditText = findViewById(R.id.policyNoEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        statusEditText = findViewById(R.id.statusEditText);
        updateStatusButton = findViewById(R.id.updateStatusButton);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Get the list of users with policies and set up the RecyclerView
        List<User> userList = databaseHelper.getUsersWithPolicy();
        userAdapter = new UserAdapter(userList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userAdapter);

        // Set the update button click listener
        updateStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String policyNo = policyNoEditText.getText().toString();
                String username = usernameEditText.getText().toString();
                String status = statusEditText.getText().toString();

                if (!policyNo.isEmpty() && !username.isEmpty() && !status.isEmpty()) {
                    // Update the user policy status in the database
                    databaseHelper.updateUserPolicy(username, policyNo, status);
                    Toast.makeText(AdminActivity.this, "Status updated successfully", Toast.LENGTH_SHORT).show();

                    // Refresh the RecyclerView
                    List<User> updatedUserList = databaseHelper.getUsersWithPolicy();
                    userAdapter = new UserAdapter(updatedUserList);
                    recyclerView.setAdapter(userAdapter);
                } else {
                    Toast.makeText(AdminActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
