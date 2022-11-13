package org.example.salaryPayment.controller;

import org.assertj.core.api.SoftAssertions;
import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.dto.EmployeeDivisionResponse;
import org.example.salaryPayment.dto.UpdEmployeeRequest;
import org.example.salaryPayment.mapper.EmployeeMapper;
import org.example.salaryPayment.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;
    @Mock
    private EmployeeMapper mapper;

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    UpdEmployeeRequest request;
    @Mock
    EmployeeDivisionResponse response;
    @Mock
    EmployeeDivisionModel model;

    private static final Long ID = 1L;

    @Test
    public void shouldCreate() {

        // when
        var actualResult = employeeController.create(request);

        // then
        verify(employeeService).save(request);
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).isEqualTo("New employee was successfully created");
        });
    }

    @Test
    public void shouldGetAll() {
        // given
        var models = Collections.singletonList(model);
        when(employeeService.getAll()).thenReturn(models);
        when(mapper.mapToResponse(model)).thenReturn(response);

        // when
        var actualResult = employeeController.getAll();

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).containsExactly(response);
        });
    }

    @Test
    public void shouldGetById() {
        // given
        when(employeeService.getById(ID)).thenReturn(model);
        when(mapper.mapToResponse(model)).thenReturn(response);

        // when
        var actualResult = employeeController.getById(ID);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).isEqualTo(response);
        });
    }

    @Test
    public void shouldUpdate() {

         // when
        var actualResult = employeeController.update(request,ID);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).isEqualTo(
                    "employee data with id: " + ID + " was successfully updated");
        });
    }

    @Test
    public void shouldDelete() {

        // when
        var actualResult = employeeController.delete(ID);

        // then
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResult.getStatusCode()).isEqualTo(HttpStatus.OK);
            softly.assertThat(actualResult.getBody()).isEqualTo(
                    "employee data with id: " + ID + " was successfully deleted");
        });
    }
}