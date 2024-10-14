package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private EditText editTextUsername, editTextPassword;
    private Button buttonSubmit;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        dbHelper = new DatabaseHelper(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if (toggleButton.isChecked()) {
                    // Login

                    if (username.equals("admin") && password.equals("admin"))
                    {
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        startActivity(intent);

                    }

                    else if (dbHelper.checkUser(username, password)) {
                        Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        if (dbHelper.checkUser(username, password)) {
                            Intent intent = new Intent(MainActivity.this, PolicyListActivity.class);
                            intent.putExtra("username", username);
                            startActivity(intent);
                            finish(); // Optional: Close MainActivity to prevent going back
                        } else {
                            Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Register
                    if (!username.isEmpty() && !password.isEmpty()) {
                        dbHelper.addUser(username, password);
                        Toast.makeText(MainActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}