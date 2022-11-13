package org.example.salaryPayment.dto.salaryReport;

import lombok.Data;
import org.example.salaryPayment.enums.ReportTarget;

import java.util.List;

@Data
public class SalaryPaymentResponse {

    private String divisionCode;
    private ReportTarget reportTarget;
    private SalaryPaymentPeriod salaryPaymentPeriod;
    private List<SalaryPaymentReportItem> salaryReportItems;
}
