package org.example.salaryPayment.dto;

import lombok.Data;
import org.example.salaryPayment.enums.Title;

@Data
public class EmployeeDivisionResponse {

    private Long employeeId;

    private String code;

    private String firstName;

    private String lastName;

    private Title title;
}
