package com.example.final203;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class view_employees extends AppCompatActivity {

    private LinearLayout employeeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employees);

        employeeContainer = findViewById(R.id.employeeContainer);

        fetchEmployeeData();

        Button backButton = findViewById(R.id.button_back);
        backButton.setOnClickListener(v -> finish());
    }

    private void fetchEmployeeData() {
        EmployeeApiService employeeApi = ApiClient.getRetrofitInstance().create(EmployeeApiService.class);

        Call<List<Employee>> call = employeeApi.getAllEmployees();
        call.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Employee> employees = response.body();

                    for (Employee emp : employees) {
                        addEmployeeToContainer(emp);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                // Handle API failure
            }
        });
    }

    private void addEmployeeToContainer(Employee employee) {

        TextView employeeView = new TextView(this);
        employeeView.setText(employee.name() + " " + employee.getSurname());
        employeeView.setTextSize(18);
        employeeView.setPadding(16, 16, 16, 16);

        employeeContainer.addView(employeeView);
    }
}
