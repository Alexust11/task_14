package com.example.task_14.controller;

import com.example.task_14.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class EmployeeControllerTest {


    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindMaxSalaryByDepartment() {
        List<Object[]> maxSalaryList = new ArrayList<>();
        Object[] maxSalary1 = {"Иванов", 100000.0};
        Object[] maxSalary2 = {"Петров", 80000.0};
        maxSalaryList.add(maxSalary1);
        maxSalaryList.add(maxSalary2);

        Mockito.when(employeeRepository.findMaxSalaryByDepartment()).thenReturn(maxSalaryList);

        List<Object[]> result = employeeController.findMaxSalaryByDepartment();

        Assert.assertEquals(maxSalaryList.size(), result.size());
        Assert.assertEquals(maxSalaryList.get(0)[0], result.get(0)[0]);
        Assert.assertEquals(maxSalaryList.get(0)[1], result.get(0)[1]);
        Assert.assertEquals(maxSalaryList.get(1)[0], result.get(1)[0]);
        Assert.assertEquals(maxSalaryList.get(1)[1], result.get(1)[1]);
    }

    @Test
    public void testFindAvgSalaryByDepartment() {
        List<Object[]> avgSalaryList = new ArrayList<>();
        Object[] avgSalary1 = {"Иванов", 70000.0};
        Object[] avgSalary2 = {"Петров", 60000.0};
        avgSalaryList.add(avgSalary1);
        avgSalaryList.add(avgSalary2);

        Mockito.when(employeeRepository.findAvgSalaryByDepartment()).thenReturn(avgSalaryList);

        List<Object[]> result = employeeController.findAvgSalaryByDepartment();

        Assert.assertEquals(avgSalaryList.size(), result.size());
        Assert.assertEquals(avgSalaryList.get(0)[0], result.get(0)[0]);
        Assert.assertEquals(avgSalaryList.get(0)[1], result.get(0)[1]);
        Assert.assertEquals(avgSalaryList.get(1)[0], result.get(1)[0]);
        Assert.assertEquals(avgSalaryList.get(1)[1], result.get(1)[1]);
    }
}