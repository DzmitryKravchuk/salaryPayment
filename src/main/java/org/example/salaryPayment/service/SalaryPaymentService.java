package org.example.salaryPayment.service;

import org.example.salaryPayment.dto.salaryReport.SalaryPaymentRequest;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentResponse;

public interface SalaryPaymentService {
    SalaryPaymentResponse getReport (SalaryPaymentRequest request);
}
