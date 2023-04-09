package pro.sky.homework25.employeeService;

import pro.sky.homework25.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Collection showEmployees();
}
