package com.example.final203;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


public interface EmployeeApiService {
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    @POST("employees")
    Call<Void> addEmployee(@Body Employee employee);

    @PUT("employees/{id}")
    Call<Void> updateEmployee(@Path("id") int id, @Body Employee employee);

    @DELETE("employees/{id}")
    Call<Void> deleteEmployee(@Path("id") int id);

    @POST("holidays")
    Call<Void> requestHoliday(@Body hrequests request);

    @GET("holidays")
    Call<List<hrequests>> getHolidayRequests();

    @PUT("holidays/{id}")
    Call<Void> updateHolidayStatus(@Path("id") int id, @Body hrequests updatedStatus);
}
