package com.example.bootcamphw1.controller;

import com.example.bootcamphw1.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/employee")
public class ClientController {

    @GetMapping("/get")
    @ResponseBody
    public String getEmployee(){
        long id = 5;
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/employee/" + id;
        Employee response = restTemplate.getForObject(url, Employee.class);
        return response.toString();
    }

    @GetMapping("/post")
    @ResponseBody
    public String postProduct(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/employee";
        Employee employee = new Employee(3, "Foo Fighters", 12000);
        Employee result = restTemplate.postForObject(url, employee, Employee.class);
        return result.toString();
    }

    @GetMapping("/put")
    @ResponseBody
    public String putEmployee(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/employee";
        Employee employee = new Employee(4, "Bart Fawn", 14000);
        restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
        return "Koyma basarili";
    }

    @GetMapping("/delete")
    @ResponseBody
    public String deleteProduct() {
        long id = 4;
        String url = "http://localhost:8080/api/employee/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "silme basarili";
    }


}
