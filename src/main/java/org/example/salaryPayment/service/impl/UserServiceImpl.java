package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.salaryPayment.exception.PasswordIncorrectException;
import org.example.salaryPayment.exception.ResourceNotFoundException;
import org.example.salaryPayment.exception.UserNotAuthorisedException;
import org.example.salaryPayment.persistence.entity.User;
import org.example.salaryPayment.persistence.repositoty.UserRepository;
import org.example.salaryPayment.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public User getByLogin(String login) {
        log.info("getByLogin: {}", login);
        return repository.findByLogin(login).
                orElseThrow(() -> new ResourceNotFoundException("User with login " + login + " not found"));
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {
        User user = getByLogin(login);
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        throw new PasswordIncorrectException("wrong password");
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        var u = getByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, getAuthorities());
    }

    @Override
    public User getAuthUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        var principal = (auth != null) ? auth.getName() : null;
        if (principal == null) {
            throw new UserNotAuthorisedException("Access denied - not authorized user");
        }
        return getByLogin(principal);
    }

    // By default, user has only one role ROLE_USER
    private Set<GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }


}
