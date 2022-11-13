package org.example.salaryPayment.dto.salaryReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.salaryPayment.enums.Title;

@Data
@AllArgsConstructor
public class SalaryPaymentReportItem {
    private Title title;
    private Integer salaryPayed;
}
