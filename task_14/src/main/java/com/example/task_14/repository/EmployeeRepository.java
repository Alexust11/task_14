package com.example.task_14.repository;

import com.example.task_14.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e.department, MAX(e.salary) FROM Employee e GROUP BY e.department HAVING COUNT(e) > 1")
    List<Object[]> findMaxSalaryByDepartment();
    @Query("SELECT e.department, AVG(e.salary) FROM Employee e GROUP BY e.department HAVING COUNT(e) > 1")
    List<Object[]> findAvgSalaryByDepartment();

}
