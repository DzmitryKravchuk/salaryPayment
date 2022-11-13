package org.example.salaryPayment.service.salaryReportCalrulator;

import org.example.salaryPayment.dto.SalaryPaymentForTitleModel;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentReportItem;
import org.example.salaryPayment.enums.ReportTarget;

import java.util.List;

public interface SalaryReportCalculator {
    List<SalaryPaymentReportItem> calculateReportItems(List <SalaryPaymentForTitleModel> models);

    ReportTarget getType();
}
