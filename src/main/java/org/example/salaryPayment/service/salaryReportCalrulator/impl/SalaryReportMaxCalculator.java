package org.example.salaryPayment.service.salaryReportCalrulator.impl;

import org.example.salaryPayment.dto.SalaryPaymentForTitleModel;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentReportItem;
import org.example.salaryPayment.enums.ReportTarget;
import org.example.salaryPayment.enums.Title;
import org.example.salaryPayment.service.salaryReportCalrulator.SalaryReportCalculator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SalaryReportMaxCalculator implements SalaryReportCalculator {
    @Override
    public List<SalaryPaymentReportItem> calculateReportItems(List<SalaryPaymentForTitleModel> models) {
        List<SalaryPaymentReportItem> reportItems = new ArrayList<>();
        for (var title: Title.values()) {
            var targetValue = models.stream()
                    .filter(o -> o.getTitle().equals(title))
                    .map(SalaryPaymentForTitleModel::getSalaryPayed)
                    .mapToInt(v -> v)
                    .max().orElse(0);
            reportItems.add(new SalaryPaymentReportItem(title, targetValue));
        }
        return reportItems;
    }

    @Override
    public ReportTarget getType() {
        return ReportTarget.MAX;
    }
}
