package org.example.salaryPayment.service;

import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(UpdEmployeeRequest employee);

    EmployeeDivisionModel getById(Long id);

    List<EmployeeDivisionModel> getAll();

    void delete(Long id);

    void update(UpdEmployeeRequest employee, Long id);
}
