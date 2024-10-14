package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThankyouActivity extends AppCompatActivity {

    private TextView textViewThankYou, textViewPolicySummary;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        // Initialize views
        textViewThankYou = findViewById(R.id.textViewThankYou);
        textViewPolicySummary = findViewById(R.id.textViewPolicySummary);
        buttonLogout = findViewById(R.id.buttonLogout);

        // Get the policy details passed from the previous activity
        Intent intent = getIntent();
        String username = intent.getStringExtra("name");
        String policyName = intent.getStringExtra("pname");
        String policyNumber = intent.getStringExtra("pno");

        // Display a thank-you message with policy details
        String message = "Thank you, " + username + "!\n" +
                "You have successfully purchased the policy:\n" +
                "Policy Name: " + policyName + "\n" +
                "Policy Number: " + policyNumber;
        textViewPolicySummary.setText(message);

        // Logout button click listener
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to MainActivity (login screen) on logout
                Intent logoutIntent = new Intent(ThankyouActivity.this, MainActivity.class);
                logoutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish(); // Close ThankYouActivity
            }
        });
    }
}
