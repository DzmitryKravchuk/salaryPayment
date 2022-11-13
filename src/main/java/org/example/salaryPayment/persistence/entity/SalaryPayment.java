package org.example.salaryPayment.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.relational.core.mapping.Table;

@Table("salary_payment")
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SalaryPayment extends AbstractEntity{

    private Integer perYear;

    private Integer perMonth;

    private Integer expectedWorkedTime;

    private Integer actualWorkedTime;

    private Integer salaryRate;

    private Integer salaryPayed;

    private Long EmployeeId;
}
