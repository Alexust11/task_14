package com.example.task_14.controller;

import com.example.task_14.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/max-salary-by-department")
    public List<Object[]> findMaxSalaryByDepartment() {
        return employeeRepository.findMaxSalaryByDepartment();
    }
    @GetMapping("/avg-salary-by-department")
    public List<Object[]> findAvgSalaryByDepartment() {
        return employeeRepository.findAvgSalaryByDepartment();
    }
}
