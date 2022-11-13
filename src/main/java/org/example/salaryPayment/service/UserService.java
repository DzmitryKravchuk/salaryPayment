package org.example.salaryPayment.service;

import org.example.salaryPayment.persistence.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getByLogin(String login);

    User getByLoginAndPassword(String login, String password);

    UserDetails loadUserByUsername(String login);

    User getAuthUser();
}
