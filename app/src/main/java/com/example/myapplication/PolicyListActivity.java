package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PolicyListActivity extends AppCompatActivity {

    private ListView listViewPolicies;
    private List<Policy> policyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_list);

        listViewPolicies = findViewById(R.id.listViewPolicies);
        policyList = new ArrayList<>();

        // Sample data for policies
        policyList.add(new Policy("POL123", "Basic Bike Insurance", "$100"));
        policyList.add(new Policy("POL456", "Comprehensive Bike Insurance", "$250"));
        policyList.add(new Policy("POL789", "Third Party Liability Insurance", "$50"));

        ArrayAdapter<Policy> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, policyList);
        listViewPolicies.setAdapter(adapter);
        String username=getIntent().getStringExtra("username");

        listViewPolicies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Policy selectedPolicy = policyList.get(position);

                Intent intent = new Intent(PolicyListActivity.this, PolicyDetailsActivity.class);
                intent.putExtra("policyNumber", selectedPolicy.getPolicyNumber());
                intent.putExtra("planName", selectedPolicy.getPlanName());
                intent.putExtra("insuranceAmount", selectedPolicy.getInsuranceAmount());
                intent.putExtra("username", username); // Pass the username
                startActivity(intent);
            }
        });
    }
}