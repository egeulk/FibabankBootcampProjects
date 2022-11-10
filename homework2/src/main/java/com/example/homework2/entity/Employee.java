package com.example.homework2.entity;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    private String employeeName;

    private long monthlySalary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee(long employeeId, String employeeName, long monthlySalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(long monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
