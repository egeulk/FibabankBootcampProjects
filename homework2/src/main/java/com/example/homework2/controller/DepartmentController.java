package com.example.homework2.controller;

import com.example.homework2.entity.Department;
import com.example.homework2.entity.Employee;
import com.example.homework2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/department/new")
    public String insertDepartment(){
        Department department = new Department();
        department.setDepartmentId(0);
        department.setDepartmentName("Fizik");

        Employee employee = new Employee(0, "ege", 33);
        employee.setDepartment(department);
        department.addEmployee(employee);

        return "insert yapildi";
    }
}
