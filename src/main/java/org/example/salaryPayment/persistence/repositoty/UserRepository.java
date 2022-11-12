package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByLogin(String code);

}
