package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PolicyDetailsActivity extends AppCompatActivity {

    private TextView textViewPolicyNumber, textViewPlanName, textViewInsuranceAmount;
    private Button buttonBuy, buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_details);

        textViewPolicyNumber = findViewById(R.id.textViewPolicyNumber);
        textViewPlanName = findViewById(R.id.textViewPlanName);
        textViewInsuranceAmount = findViewById(R.id.textViewInsuranceAmount);
        buttonBuy = findViewById(R.id.buttonBuy);
        buttonCancel = findViewById(R.id.buttonCancel);
        TextView textuser =findViewById(R.id.User_name);
        // Get data from the intent
        String policyNumber = getIntent().getStringExtra("policyNumber");
        String planName = getIntent().getStringExtra("planName");
        String insuranceAmount = getIntent().getStringExtra("insuranceAmount");
        String User = getIntent().getStringExtra("username");



        // Set data to the TextViews
        textViewPolicyNumber.setText("Policy Number: " + policyNumber);
        textViewPlanName.setText("Plan Name: " + planName);
        textViewInsuranceAmount.setText("Insurance Amount: " + insuranceAmount);
        textuser.setText(User);

        // Set up button click listeners
        buttonBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle policy purchase logic here (e.g., update database)
                // For now, show a toast message
//                Toast.makeText(PolicyDetailsActivity.this, "Policy Purchased!", Toast.LENGTH_SHORT).show();
                DatabaseHelper dbHelper = new DatabaseHelper(PolicyDetailsActivity.this);
                dbHelper.updateUserPolicy(User,policyNumber, "Active");
                Intent i =new Intent(PolicyDetailsActivity.this,ThankyouActivity.class);
                i.putExtra("name",User);
                i.putExtra("pno",policyNumber);
                i.putExtra("pname",planName);
                i.putExtra("amount",insuranceAmount);
                i.putExtra("status","active");
                startActivity(i);
                finish();

            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close this activity and return to the previous one
            }
        });
    }
}