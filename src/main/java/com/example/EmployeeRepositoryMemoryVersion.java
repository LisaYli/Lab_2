package com.example;

import java.util.List;

public class EmployeeRepositoryMemoryVersion implements EmployeeRepository {

    List<Employee> employeeList;

    public EmployeeRepositoryMemoryVersion(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public List<Employee> findAll() {
return employeeList;
    }

    @Override
    public Employee save(Employee e) {

        for (Employee emp : employeeList) {
            if (emp.getId().equals(e.getId())) {
                employeeList.remove(emp);
                break;
            }
        }
        employeeList.add(e);
        int index = employeeList.indexOf(e);
        return employeeList.get(index);
    }
}
