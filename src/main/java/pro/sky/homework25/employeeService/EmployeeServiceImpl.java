package pro.sky.homework25.employeeService;

import org.springframework.stereotype.Service;
import pro.sky.homework25.Employee;
import pro.sky.homework25.EmployeeAlreadyAddedException;
import pro.sky.homework25.EmployeeNotFoundException;
import pro.sky.homework25.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees;

    public EmployeeServiceImpl() {
        employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException("Сотрудник имеется в списке");
            }
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.size(); i++) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Collection<Employee> showEmployees() {
        return Collections.unmodifiableCollection(employees);
    }
}


