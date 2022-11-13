package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.exception.AbstractBusinessException;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.persistence.entity.Employee;
import org.example.salaryPayment.persistence.repositoty.EmployeeRepository;
import org.example.salaryPayment.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    private final EmployeeMapper mapper;

    @Override
    public void save(UpdEmployeeRequest employee) {
        log.info("EmployeeServiceImpl save {}", employee);
        var entity = mapper.mapToEntity(employee);
        repository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDivisionModel getById(Long id) {
        log.info("EmployeeServiceImpl get by id: {}", id);
        return repository.findByIdFetchDivision(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee with index " + id + " not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDivisionModel> getAll() {
        log.info("EmployeeServiceImpl find ALL");
        return repository.findEmployeesFetchDivision();
    }

    @Override
    public void delete(Long id) {
        log.info("EmployeeServiceImpl delete by id: {}", id);
        repository.deleteById(id);
    }

    @Override
    public void update(UpdEmployeeRequest employee, Long id) {
        log.info("EmployeeServiceImpl update with id: {}", id);
        var employeeFromBase = getById(id);
        assert (employeeFromBase) != null;
        if (!Objects.equals(employee.getId(), id)) {
            throw new AbstractBusinessException("Employee from request has index " + employee.getId() + " and doesnt match index from url " + id);
        }
        save(employee);
    }
}
