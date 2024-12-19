package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") String id) { return employeeService.get(id);}

    @PostMapping("/employee-create")
    public Employee createEmployee(@RequestBody Employee employee) { return employeeService.save(employee);}

    @GetMapping("/employee-all")
    public List<Employee> getAllEmployees() { return employeeService.findAll();}
}

