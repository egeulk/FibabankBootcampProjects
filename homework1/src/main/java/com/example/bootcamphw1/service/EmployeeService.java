package com.example.bootcamphw1.service;

import com.example.bootcamphw1.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee find(long employeeId);

    public List<Employee> findAll();

    public void addEmployee(Employee employee);

    public void deleteEmployee(long employeeId);

    public void updateEmployee(Employee employee);
}
