import com.example.final203.Employee;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface EmployeeApi {

    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    @GET("employees/get/{id}")
    Call<Employee> getEmployeeById(@Path("id") int id);
}
