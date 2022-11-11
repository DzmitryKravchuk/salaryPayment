package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.exception.AbstractBusinessException;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.persistence.entity.Employee;
import org.example.salaryPayment.persistence.repositoty.EmployeeRepository;
import org.example.salaryPayment.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public void save(Employee employee) {
        log.info("EmployeeServiceImpl save {}", employee);
        repository.save(employee);
    }

    @Override
    public Employee getById(Long id) {
        log.info("EmployeeServiceImpl get by id: {}", id);
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee with index " + id + " not found"));
    }

    @Override
    public List<Employee> getAll() {
        log.info("EmployeeServiceImpl find ALL");
        return (List<Employee>) repository.findAll();
    }

    @Override
    public void delete(Long id) {
        log.info("EmployeeServiceImpl delete by id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public void update(Employee employee, Long id) {
        log.info("EmployeeServiceImpl update with id: {}", id);
        var employeeFromBase = getById(id);
        assert (employeeFromBase) != null;
        if (!Objects.equals(employee.getId(), id)) {
            throw new AbstractBusinessException("Employee from request has index " + employee.getId() + " and doesnt match index from url " + id);
        }
        save(employee);
    }
}
