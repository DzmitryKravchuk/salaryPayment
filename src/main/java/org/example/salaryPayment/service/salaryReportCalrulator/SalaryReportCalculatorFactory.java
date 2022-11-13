package org.example.salaryPayment.service.salaryReportCalrulator;

import org.example.salaryPayment.dto.SalaryPaymentForTitleModel;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentReportItem;
import org.example.salaryPayment.enums.ReportTarget;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SalaryReportCalculatorFactory {
    private final Map<ReportTarget, SalaryReportCalculator> calculators;

    public SalaryReportCalculatorFactory(List<SalaryReportCalculator> calculators) {
        this.calculators = calculators.stream()
                .collect(Collectors.toMap(SalaryReportCalculator::getType, Function.identity()));
    }

    public SalaryReportCalculator getCalculator(ReportTarget type) {
        return calculators.getOrDefault(type, getDefaultCalculator(type));
    }

    private SalaryReportCalculator getDefaultCalculator(ReportTarget type) {
        return new SalaryReportCalculator() {

            @Override
            public List<SalaryPaymentReportItem> calculateReportItems(List<SalaryPaymentForTitleModel> models) {
                var errorMessage = String.format("Total Cost Calculator is not implemented for %s RentTimeUnit", type);
                throw new RuntimeException(errorMessage);
            }

            @Override
            public ReportTarget getType() {
                return null;
            }
        };
    }
}
