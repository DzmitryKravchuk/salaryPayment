package org.example.salaryPayment.dto.salaryReport;

import lombok.Data;

@Data
public class SalaryPaymentPeriod {
    private int year;
    private int monthFrom;
    private int monthTo;

    public SalaryPaymentPeriod(int perYear, int month, boolean aggregated) {
        this.year = perYear;
        this.monthTo = month;
        this.monthFrom = (aggregated) ? 1 : month;
    }
}
