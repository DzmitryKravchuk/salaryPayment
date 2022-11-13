package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.dto.SalaryPaymentForTitleModel;
import org.example.salaryPayment.persistence.entity.SalaryPayment;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalaryPaymentRepository extends CrudRepository <SalaryPayment, Long> {

    @Query("SELECT e.TITLE as title, "
            + "p.SALARY_PAYED as salary_payed, "
            + "p.EXPECTED_WORKED_TIME as expected_worked_time, "
            + "p.ACTUAL_WORKED_TIME as acrual_worked_time, "
            + "FROM \"salary_payment\" p "
            + "JOIN \"employee\" e ON e.ID = p.EMPLOYEE_ID "
            + "WHERE e.DIVISION_ID = :divisionId "
            + "AND p.PER_YEAR = :perYear "
            + "AND p.PER_MONTH IN (:perMonthItems)"
    )
    List<SalaryPaymentForTitleModel> findPaymentsFetchTitle(Long divisionId, int perYear, List <Integer> perMonthItems);
}
