package org.example.salaryPayment.service.impl;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.persistence.entity.Employee;
import org.example.salaryPayment.persistence.repositoty.EmployeeRepository;
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
    @InjectMocks
    private EmployeeServiceImpl service;

    @Mock
    private static Employee employee;

    @Mock
    private static EmployeeDivisionModel model;

    @Mock
    private static UpdEmployeeRequest request;

    private static final Long ID = 1L;

    @Test
    void shouldGetAll() {
        // given
        when(repository.findEmployeesFetchDivision()).thenReturn(Collections.singletonList(model));

        // when
        var employees = service.getAll();

        // then
        Assertions.assertThat(employees).hasSize(1)
                .containsOnly(model);
    }

    @Test
    void shouldGetById() {
        // given
        when(repository.findByIdFetchDivision(ID)).thenReturn(java.util.Optional.of(model));

        // when
        var actualResult = service.getById(ID);

        // then
        Assertions.assertThat(actualResult).isEqualTo(model);
    }

    @Test
    void shouldThrowException() {
        // given
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.empty());

        // when-then
        Assertions.assertThatThrownBy(() -> service.getById(ID)).isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Employee with index " + ID + " not found");

    }

    @Test
    void shouldSave() {
        //given
        when(mapper.mapToEntity(request)).thenReturn(employee);

        // when
        service.save(request);

        // then
        verify(repository).save(employee);
    }

    @Test
    void shouldUpdate() {
        // given
        when(mapper.mapToEntity(request)).thenReturn(employee);
        when (request.getId()).thenReturn(ID);
        when(repository.findByIdFetchDivision(ID)).thenReturn(Optional.of(model));

        // when
        service.update(request, ID);

        // then
        verify(repository).save(employee);
    }

    @Test
    void shouldDelete() {
        // when
        service.delete(ID);

        // then
        verify(repository).deleteById(ID);
    }

}