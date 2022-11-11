package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.persistence.entity.Division;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DivisionRepository extends CrudRepository<Division, Long> {

    Optional<Division> findByCode(String code);
}
