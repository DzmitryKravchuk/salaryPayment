package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.persistence.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByFirstNameContainingOrLastNameContaining (String firstName, String lastName);

    List<Employee> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
}
