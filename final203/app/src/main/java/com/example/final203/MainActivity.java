package com.example.final203;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button adminButton = findViewById(R.id.adminButton);
        Button employeeButton = findViewById(R.id.employeeButton);

        adminButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, homeadmin.class);
            startActivity(intent);
        });

        employeeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, employee_home.class);
            startActivity(intent);
        });
    }
}
