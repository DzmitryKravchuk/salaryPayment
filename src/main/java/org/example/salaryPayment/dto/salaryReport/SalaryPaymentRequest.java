package org.example.salaryPayment.dto.salaryReport;

import lombok.Data;
import org.example.salaryPayment.enums.ReportTarget;

@Data
public class SalaryPaymentRequest {
    private ReportTarget reportTarget;
    private int year;
    private int month;
    private boolean isAggregated;
}
