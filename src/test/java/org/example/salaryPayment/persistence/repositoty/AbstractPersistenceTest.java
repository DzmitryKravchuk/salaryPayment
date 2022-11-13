package org.example.salaryPayment.persistence.repositoty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJdbcTest
public class AbstractPersistenceTest {

    @Autowired
    protected DivisionRepository divisionRepository;

    @Autowired
    protected EmployeeRepository employeeRepository;

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected SalaryPaymentRepository salaryPaymentRepository;
}
