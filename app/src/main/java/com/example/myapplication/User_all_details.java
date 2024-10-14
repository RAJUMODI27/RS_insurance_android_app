package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class User_all_details extends AppCompatActivity {
    TextView name,pname,pno,pstatus,amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user_all_details);


        name=findViewById(R.id.Uname);
        pname=findViewById(R.id.Pname);
        amount=findViewById(R.id.Amount);
        pstatus=findViewById(R.id.Pstatus);
        pno=findViewById(R.id.Pnumber);

        name.setText(getIntent().getStringExtra("name"));
        pname.setText(getIntent().getStringExtra("pname"));
        amount.setText(getIntent().getStringExtra("amount"));
        pstatus.setText(getIntent().getStringExtra("status"));
        pno.setText(getIntent().getStringExtra("pno"));

    }
}