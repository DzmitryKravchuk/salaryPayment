package org.example.salaryPayment.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentRequest;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentResponse;
import org.example.salaryPayment.service.SalaryPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/salary")
@RequiredArgsConstructor
public class SalaryPaymentController {
    private final SalaryPaymentService salaryPaymentService;

    @GetMapping()
    public ResponseEntity<SalaryPaymentResponse> getSalaryPaymentReport(@RequestBody SalaryPaymentRequest request) {
        log.info("getSalaryPaymentReport()");
        var response = salaryPaymentService.getReport(request);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
