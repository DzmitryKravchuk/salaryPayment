package org.example.salaryPayment.persistence.repositoty;

import org.example.salaryPayment.persistence.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
