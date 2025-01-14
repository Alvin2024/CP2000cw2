package com.example.final203;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class homeadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeadmin);

        Button employeesButton = findViewById(R.id.employees_button);
        Button holidayRequestsButton = findViewById(R.id.holiday_requests_button);
        Button notificationsButton = findViewById(R.id.notifications_button);
        Button addEmployeeButton = findViewById(R.id.add_employee_button);
        Button logoutButton = findViewById(R.id.logout_button);

        employeesButton.setOnClickListener(v -> {
            Intent intent = new Intent(homeadmin.this, view_employees.class);
            startActivity(intent);
        });

        holidayRequestsButton.setOnClickListener(v -> {
            Intent intent = new Intent(homeadmin.this, employee_request_holiday.class);
            startActivity(intent);
        });

        notificationsButton.setOnClickListener(v -> {
            Intent intent = new Intent(homeadmin.this, notificationsadmin.class);
            startActivity(intent);
        });

        addEmployeeButton.setOnClickListener(v -> {
            Intent intent = new Intent(homeadmin.this, AddEmployeeActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(homeadmin.this, MainActivity.class);
            startActivity(intent);
            finish(); // Close the current activity to prevent returning with back button
        });
    }
}
