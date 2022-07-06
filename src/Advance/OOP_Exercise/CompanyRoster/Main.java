package Advance.OOP_Exercise.CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = sc.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;

            Department departmentObject = departments.stream()
                    .filter(x -> x.getDepartment().equals(department))
                    .findFirst()
                    .orElse(null);

            if (departmentObject == null){
                departmentObject = new Department(department);
                departments.add(departmentObject);
            }

            switch (employeeInfo.length){
                case 4:
                    employee = new Employee(name, salary, position);
                    break;
                case 6:
                    String email = employeeInfo[4];
                    int age = Integer.parseInt(employeeInfo[5]);
                    employee = new Employee(name, salary,position, email, age);
                    break;
                case 5:
                    if(employeeInfo[4].matches("\\d+")){
                        int employeeAge = Integer.parseInt(employeeInfo[4]);
                        employee = new Employee(name,salary,position, employeeAge);
                    } else {
                        employee = new Employee(name, salary, position, employeeInfo[4]);
                    }
                    break;
            }

            departmentObject.getEmployees().add(employee);
        }

        Department department = departments.stream()
                .max(Comparator.comparing(Department::getAverageSalary))
                .orElse(null);

        System.out.println("Highest Average Salary: " + department.getDepartment());
        department.getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getName).reversed())
                .forEach(System.out::println);
    }
}
