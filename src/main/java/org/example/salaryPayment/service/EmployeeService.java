package org.example.salaryPayment.service;

import org.example.salaryPayment.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);

    Employee getById(Long id);

    List<Employee> getAll();

    void delete(Long id);

    void update(Employee employee, Long id);
}
