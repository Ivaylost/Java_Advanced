package OOP_Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String department;
    private List<Employee> employees;

    public Department(String department) {
        this.department = department;
        this.employees = new ArrayList<>();
    }

    public String getDepartment() {
        return department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double getAverageSalary(){
        return this.employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0);
    }
}
