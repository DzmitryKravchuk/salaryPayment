package org.example.salaryPayment.dto;

import lombok.Data;
import org.example.salaryPayment.enums.Title;

@Data
public class SalaryPaymentForTitleModel {
    private Title title;

    private Integer salaryPayed;

    private Integer expectedWorkedTime;

    private Integer actualWorkedTime;

}
