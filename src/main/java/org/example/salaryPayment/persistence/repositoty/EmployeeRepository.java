package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.dto.EmployeeDivisionModel;
import org.example.salaryPayment.persistence.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    // if search by only one field, another should have blank var ""
    List<Employee> findByFirstNameContainingAndLastNameContaining(String firstName, String lastName);

    @Query("SELECT d.CODE as code, "
            + "e.ID as employee_id, "
            + "e.FIRST_NAME as first_name, "
            + "e.LAST_NAME as last_name, "
            + "e.TITLE as title "
            + "FROM \"employee\" e "
            + "JOIN \"division\" d ON d.ID = e.DIVISION_ID"
    )
    List<EmployeeDivisionModel> findEmployeesFetchDivision();

    @Query("SELECT d.CODE as code, "
            + "e.ID as employee_id, "
            + "e.FIRST_NAME as first_name, "
            + "e.LAST_NAME as last_name, "
            + "e.TITLE as title "
            + "FROM \"employee\" e "
            + "JOIN \"division\" d ON d.ID = e.DIVISION_ID "
            + "WHERE e.ID = :id"
    )
    Optional<EmployeeDivisionModel> findByIdFetchDivision(Long id);
}
