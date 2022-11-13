package org.example.salaryPayment.service.impl;

import org.assertj.core.api.Assertions;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentReportItem;
import org.example.salaryPayment.dto.salaryReport.SalaryPaymentRequest;
import org.example.salaryPayment.enums.ReportTarget;
import org.example.salaryPayment.enums.Title;
import org.example.salaryPayment.service.SalaryPaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.Set;

@ActiveProfiles("test")
@SpringBootTest
public class SalaryPaymentServiceIntegrationTest {
    @Autowired
    SalaryPaymentService salaryPaymentService;

    private SalaryPaymentRequest request;

    @BeforeEach
    void setUp() {
        request = new SalaryPaymentRequest();
        request.setAggregated(false);
        request.setMonth(1);
        request.setYear(2022);
        request.setReportTarget(ReportTarget.MIN);

        var userDetails = new org.springframework.security.core.userdetails.User("BA", "password", true, true, true, true, getAuthorities());
        var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        var securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    private Set<GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }


    @Test
    void shouldGetDataForOneMonth() {
        // given

        // when
        var actualResponse = salaryPaymentService.getReport(request);

        // then
        Assertions.assertThat(actualResponse.getSalaryReportItems()).containsExactlyInAnyOrder(
                new SalaryPaymentReportItem(Title.JUNIOR, 500),
                new SalaryPaymentReportItem(Title.MIDDLE, 1000),
                new SalaryPaymentReportItem(Title.SENIOR, 2000));
    }

    @Test
    void shouldGetDataForPeriod() {
        // given
        request.setAggregated(true);
        request.setMonth(3);
        request.setReportTarget(ReportTarget.MAX);

        // when
        var actualResponse = salaryPaymentService.getReport(request);

        // then
        Assertions.assertThat(actualResponse.getSalaryReportItems()).containsExactlyInAnyOrder(
                new SalaryPaymentReportItem(Title.JUNIOR, 755),
                new SalaryPaymentReportItem(Title.MIDDLE, 1155),
                new SalaryPaymentReportItem(Title.SENIOR, 2555));
    }

    @Test
    void shouldGetAvgDataForPeriod() {
        // given
        request.setAggregated(true);
        request.setMonth(2);
        request.setReportTarget(ReportTarget.AVG);

        // when
        var actualResponse = salaryPaymentService.getReport(request);

        // then
        Assertions.assertThat(actualResponse.getSalaryReportItems()).containsExactlyInAnyOrder(
                new SalaryPaymentReportItem(Title.JUNIOR, 625),
                new SalaryPaymentReportItem(Title.MIDDLE, 1075),
                new SalaryPaymentReportItem(Title.SENIOR, 2275));
    }
}
