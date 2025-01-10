package com.example.final203;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.final203.homeadmin;
import com.example.final203.view_employees;

public class AddEmployeeActivity extends AppCompatActivity {

    private EditText inputName, inputSurname, inputRole, inputEmail, inputAddress, inputStartDate, inputLeaves;
    private Button buttonAddEmployee, buttonBack;
    private AlvinDatabase dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addemployee);

        inputName = findViewById(R.id.input_name);
        inputSurname = findViewById(R.id.input_surname);
        inputRole = findViewById(R.id.input_department);
        inputEmail = findViewById(R.id.input_email);
        inputAddress = findViewById(R.id.input_salary);
        inputStartDate = findViewById(R.id.input_start_date);
        inputLeaves = findViewById(R.id.input_leaves);
        buttonAddEmployee = findViewById(R.id.button_add_employee);
        buttonBack = findViewById(R.id.button_back);

        dbHelper = new AlvinDatabase(this);

        buttonAddEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEmployeeActivity.this, homeadmin.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void addEmployee() {
        String name = inputName.getText().toString().trim();
        String surname = inputSurname.getText().toString().trim();
        String role = inputRole.getText().toString().trim();
        String email = inputEmail.getText().toString().trim();
        String address = inputAddress.getText().toString().trim();
        String startDate = inputStartDate.getText().toString().trim();
        String leaves = inputLeaves.getText().toString().trim();

        if (name.isEmpty() || surname.isEmpty() || role.isEmpty() || email.isEmpty() || address.isEmpty() || startDate.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("surname", surname);
        values.put("role", role);
        values.put("email", email);
        values.put("address", address);
        values.put("start_date", startDate);
        values.put("leaves", leaves);

        long newRowId = db.insert("employees", null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Employee added successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddEmployeeActivity.this, view_employees.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Failed to add employee", Toast.LENGTH_SHORT).show();
        }

        db.close();
    }

    @Override
    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    }
}