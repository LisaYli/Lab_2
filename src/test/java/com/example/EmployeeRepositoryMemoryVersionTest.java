package com.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeRepositoryMemoryVersionTest {

List<Employee>employeeList = new ArrayList<>();

    EmployeeRepository employeeRepository = new EmployeeRepositoryMemoryVersion(employeeList);


    @Test
    void saveEmployeeTest() {
       employeeRepository.save(new Employee("1", 1000));
        employeeRepository.save(new Employee("2", 1000));

        assertEquals(2, employeeRepository.findAll().size());
    }


    @Test
    void cantSaveEmployeewithSameId() {
        employeeRepository.save(new Employee("1", 100));
        employeeRepository.save(new Employee("1", 200));
        employeeRepository.save(new Employee("2", 300));

        assertEquals("1", employeeRepository.findAll().get(0).getId());
        assertEquals(200, employeeRepository.findAll().get(0).getSalary());
        assertEquals(300, employeeRepository.findAll().get(1).getSalary());
        assertEquals(2, employeeRepository.findAll().size());

    }

}
