package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.persistence.entity.SalaryPayment;
import org.springframework.data.repository.CrudRepository;

public interface SalaryPaymentRepository extends CrudRepository <SalaryPayment, Long> {

}
