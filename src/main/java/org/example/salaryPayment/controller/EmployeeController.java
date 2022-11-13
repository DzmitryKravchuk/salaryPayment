package org.example.salaryPayment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.EmployeeDivisionResponse;
import org.example.salaryPayment.dto.EmployeeRequest;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.persistence.entity.Employee;
import org.example.salaryPayment.service.EmployeeService;
import org.example.salaryPayment.service.util.AuthUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/user/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper mapper;

    @GetMapping()
    public ResponseEntity<List<EmployeeDivisionResponse>> getAllEmployees() {
        log.info("getAllEmployees() called by {}", AuthUtil.getPrincipalName());

        var models = employeeService.getAll();
        var response = models.stream()
                .map(o -> mapper.mapToResponse(o))
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<Employee> create(
            @RequestBody EmployeeRequest request) {



        return null;
    }

}
