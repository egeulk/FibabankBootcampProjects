package com.example.homework2.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long departmentId;

    private String departmentName;
    @OneToMany(mappedBy = "department")
    private List<Employee> Employees = new LinkedList<Employee>();

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void addEmployee(Employee employee) {
        Employees.add(employee);
    }
}
