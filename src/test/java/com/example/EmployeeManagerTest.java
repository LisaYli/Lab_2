package com.example;

/*Todo :
    Gör minst ett test som använder en test double som du skapat själv. En test double
    klass placerar vi I test/java foldern.
 */

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {
    BankService bankService = mock(BankService.class);
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    EmployeeManager employeeManager = new EmployeeManager(employeeRepository, bankService);



    @Test
    void payEmployeeTest() {
        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("1", 100),
                new Employee("2", 200),
                new Employee("3", 300),
                new Employee("4", 100)));
        assertEquals(4, employeeManager.payEmployees());


    }

}