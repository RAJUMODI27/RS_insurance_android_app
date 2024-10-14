package com.example.myapplication;

public class Policy {
    private String policyNumber;
    private String planName;
    private String insuranceAmount;

    public Policy(String policyNumber, String planName, String insuranceAmount) {
        this.policyNumber = policyNumber;
        this.planName = planName;
        this.insuranceAmount = insuranceAmount;
    }


    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPlanName() {
        return planName;
    }

    public String getInsuranceAmount() {
        return insuranceAmount;
    }

    // Override toString to provide a user-friendly representation
    @Override
    public String toString() {
        return planName; // Display the plan name in the ListView
    }
}