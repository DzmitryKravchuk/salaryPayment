package org.example.salaryPayment.service.impl;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.exception.ResourceNotFoundException;
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
    @InjectMocks
    private EmployeeServiceImpl service;

    @Mock
    private static Employee employee;

    private static final Long ID = 1L;

    @Test
    void shouldGetAll() {
        // given
        when(repository.findAll()).thenReturn(Collections.singletonList(employee));

        // when
        var employees = service.getAll();

        // then
        Assertions.assertThat(employees).hasSize(1)
                .containsOnly(employee);
    }

    @Test
    void shouldGetById() {
        // given
        when(repository.findById(ID)).thenReturn(java.util.Optional.of(employee));

        // when
        var actualResult = service.getById(ID);

        // then
        Assertions.assertThat(actualResult).isEqualTo(employee);
    }

    @Test
    void shouldThrowException() {
        // given
        when(repository.findById(ID)).thenReturn(Optional.empty());

        // when-then
        Assertions.assertThatThrownBy(() -> service.getById(ID)).isInstanceOf(ResourceNotFoundException.class)
                .hasMessageContaining("Employee with index " + ID + " not found");

    }

    @Test
    void shouldSave() {
        // when
        service.save(employee);

        // then
        verify(repository).save(employee);
    }

    @Test
    void shouldUpdate() {
        // given
        when(repository.findById(ID)).thenReturn(Optional.of(employee));
        when (employee.getId()).thenReturn(ID);

        // when
        service.update(employee, ID);

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