package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentPeriod;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentRequest;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentResponse;
import org.example.salaryPayment.persistence.repositoty.SalaryPaymentRepository;
import org.example.salaryPayment.service.SalaryPaymentService;
import org.example.salaryPayment.service.UserService;
import org.example.salaryPayment.service.salaryReportCalrulator.SalaryReportCalculatorFactory;
import org.example.salaryPayment.service.util.DivisionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class SalaryPaymentServiceImpl implements SalaryPaymentService {
    private final UserService userService;
    private final DivisionService divisionService;
    private final SalaryPaymentRepository repository;
    private final SalaryReportCalculatorFactory calculatorFactory;

    @Override
    @Transactional(readOnly = true)
    public SalaryPaymentResponse getReport(SalaryPaymentRequest request) {
        log.info("getReport()");
        var reportTarget = request.getReportTarget();
        var divisionId = userService.getAuthUser().getDivisionId();
        var perYear = request.getYear();
        var perMonthItems = getMonthItems(request.getMonth(), request.isAggregated());
        var salaryPayments = repository.findPaymentsFetchTitle(divisionId, perYear, perMonthItems);
        var reportItems = calculatorFactory.getCalculator(reportTarget).calculateReportItems(salaryPayments);

        SalaryPaymentResponse report = new SalaryPaymentResponse();
        report.setReportTarget(reportTarget);

        var div = divisionService.getById(divisionId);
        report.setDivisionCode(div.getCode());
        report.setSalaryReportItems(reportItems);
        report.setSalaryPaymentPeriod(new SalaryPaymentPeriod(perYear, request.getMonth(), request.isAggregated()));

        return report;
    }

    private List<Integer> getMonthItems(int month, boolean aggregated) {
        List<Integer> monthItems = new ArrayList<>();;
        if (aggregated) {
            for (int i = 0; i < month; i++) {
                int b = i + 1;
                monthItems.add(b);
            }
        } else {
            monthItems.add(month);
        }
        return monthItems;
    }
}
