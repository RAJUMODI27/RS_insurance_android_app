package com.example.myapplication;

public class User {
    private String username;
    private String policyNumber;
    private String status;

    public User(String username, String policyNumber, String status) {
        this.username = username;
        this.policyNumber = policyNumber;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getStatus() {
        return status;
    }
}
