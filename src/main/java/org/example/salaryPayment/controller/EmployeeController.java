package org.example.salaryPayment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.dto.EmployeeDivisionResponse;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity<List<EmployeeDivisionResponse>> getAll() {
        log.info("getAllEmployees()");

        var models = employeeService.getAll();
        var response = models.stream()
                .map(mapper::mapToResponse)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDivisionResponse> getById(@PathVariable Long id) {
        log.info("getAllEmployees()");

        var model = employeeService.getById(id);
        var response = mapper.mapToResponse(model);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping()
    public ResponseEntity<String> create(@RequestBody UpdEmployeeRequest request) {
        log.info("create()");
        employeeService.save(request);
        var response = "New employee was successfully created";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping(("{id}"))
    public ResponseEntity<String> update(
            @RequestBody UpdEmployeeRequest request, @PathVariable Long id) {
        log.info("update()");
        employeeService.update(request, id);
        var response = "employee data with id: " + id + " was successfully updated";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping(("{id}"))
    public ResponseEntity<String> delete(@PathVariable Long id) {
        log.info("delete()");
        employeeService.delete(id);
        var response = "employee data with id: " + id + " was successfully deleted";
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
