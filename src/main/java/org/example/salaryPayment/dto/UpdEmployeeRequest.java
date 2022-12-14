package org.example.salaryPayment.dto;

import lombok.Data;
import org.example.salaryPayment.enums.Title;

@Data
public class UpdEmployeeRequest {

    private Long id;

    private String firstName;

    private String lastName;

    private Title title;

}
