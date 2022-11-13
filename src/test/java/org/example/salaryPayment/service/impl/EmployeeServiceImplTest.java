package org.example.salaryPayment.service.impl;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.persistence.entity.Division;
import org.example.salaryPayment.persistence.entity.Employee;
import org.example.salaryPayment.persistence.entity.User;
import org.example.salaryPayment.persistence.repositoty.EmployeeRepository;
import org.example.salaryPayment.service.UserService;
import org.example.salaryPayment.service.util.DivisionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {
    @Mock
    private EmployeeRepository repository;
    @Mock
    private EmployeeMapper mapper;
    @Mock
    private DivisionService divisionService;
    @Mock
    UserService userService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private static Employee employee;
    @Mock
    private static EmployeeDivisionModel model;
    @Mock
    private static UpdEmployeeRequest request;
    @Mock
    private static User user;
    @Mock
    private static Division division;

    private static final Long ID = 1L;
    private static final String CODE = "QA";

    @Test
    void shouldGetAll() {
        // given
        when(repository.findEmployeesFetchDivision()).thenReturn(Collections.singletonList(model));

        // when
        var employees = employeeService.getAll();

        // then
        Assertions.assertThat(employees).hasSize(1)
                .containsOnly(model);
    }

    @Test
    void shouldGetById() {
        // given
        when(repository.findByIdFetchDivision(ID)).thenReturn(java.util.Optional.of(model));

        // when
        var actualResult = employeeService.getById(ID);

        // then
        Assertions.assertThat(actualResult).isEqualTo(model);
    }

    @Test
    void shouldThrowException() {
        // given
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.empty());

        // when-then
        Assertions.assertThatThrownBy(() -> employeeService.getById(ID)).isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Employee with index " + ID + " not found");

    }

    @Test
    void shouldSave() {
        //given
        when(mapper.mapToEntity(request, ID)).thenReturn(employee);
        when(userService.getAuthUser()).thenReturn(user);
        when(user.getDivisionId()).thenReturn(ID);

        // when
        employeeService.save(request);

        // then
        verify(repository).save(employee);
    }

    @Test
    void shouldUpdate() {
        // given
        when(userService.getAuthUser()).thenReturn(user);
        when(mapper.mapToEntity(request, ID)).thenReturn(employee);
        when (request.getId()).thenReturn(ID);
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.of(model));
        when(user.getDivisionId()).thenReturn(ID);
        when(division.getId()).thenReturn(ID);
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.of(model));
        when(model.getCode()).thenReturn(CODE);
        when(divisionService.getByCode(CODE)).thenReturn(division);

        // when
        employeeService.update(request, ID);

        // then
        verify(repository).save(employee);
    }

    @Test
    void shouldDelete() {
        // given
        when(userService.getAuthUser()).thenReturn(user);
        when(user.getDivisionId()).thenReturn(ID);
        when(division.getId()).thenReturn(ID);
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.of(model));
        when(model.getCode()).thenReturn(CODE);
        when(divisionService.getByCode(CODE)).thenReturn(division);

        // when
        employeeService.delete(ID);

        // then
        verify(repository).deleteById(ID);
    }

}