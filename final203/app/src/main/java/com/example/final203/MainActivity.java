package com.example.final203;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        fetchEmployeeData();
    }

    private void fetchEmployeeData() {
        EmployeeApiService employeeApi = ApiClient.getRetrofitInstance().create(EmployeeApiService.class);

        Call<List<Employee>> call = employeeApi.getAllEmployees();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful()) {
                    List<Employee> employees = response.body();

                    for (Employee emp : employees) {
                        Log.d("API", "Employee: " + emp.getname() + " " + emp.getSurname());
                    }
                } else {
                    Log.e("API", "Request failed with status code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Log.e("API", "Error: " + t.getMessage());
            }
        });
    }
}
