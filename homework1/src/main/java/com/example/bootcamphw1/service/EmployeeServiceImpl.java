package com.example.bootcamphw1.service;

import com.example.bootcamphw1.Employee;

import java.util.LinkedList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    @Override
    public Employee find(long employeeId) {
        Employee employee = new Employee(employeeId, "Ege Ylker", 11111);
        System.out.println(employee.toString());
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new LinkedList<Employee>();
        Employee employeeOne = new Employee(4, "Bart Fawn", 14000);
        Employee employeeTwo = new Employee(3, "Foo Fighters", 12000);
        Employee employeeThree = new Employee(7, "Ege Ylker", 11111);
        employees.add(employeeOne);
        employees.add(employeeTwo);
        employees.add(employeeThree);
        return employees;
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println("Eklenen Eleman: " + employee.toString());
    }

    @Override
    public void deleteEmployee(long employeeId) {
        Employee deleted = new Employee(employeeId, "Murat Sanssiz", 8000);
        System.out.println("Silinen Eleman: " + deleted.toString());
    }

    @Override
    public void updateEmployee(Employee employee) {
        System.out.println("Guncellenen Eleman: " + employee.toString());
    }
}
