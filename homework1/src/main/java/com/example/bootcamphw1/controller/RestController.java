package com.example.bootcamphw1.controller;

import com.example.bootcamphw1.Employee;
import com.example.bootcamphw1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
public class RestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployee(){
        return employeeService.findAll();
    }


    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") long Id){
        return employeeService.find(Id);
    }

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/employee")
    void putEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
    }


}
