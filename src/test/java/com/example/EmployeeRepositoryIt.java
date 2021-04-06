package com.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class EmployeeRepositoryIt {

    EmployeeRepositoryMemoryVersion employeeRepo = new EmployeeRepositoryMemoryVersion(List.of(
            new Employee("1", 200),
            new Employee("2", 300),
            new Employee("3", 200),
            new Employee("4", 300)));
    BankService bankService = mock(BankService.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepo, bankService);

    @Test
    void payEmployees() {
        assertEquals(4, employeeManager.payEmployees());
    }

}
