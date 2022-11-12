package org.example.salaryPayment.service;

import org.example.salaryPayment.dto.AuthResponse;
import org.example.salaryPayment.dto.AuthRequest;
import org.example.salaryPayment.persistence.entity.User;

import javax.servlet.ServletRequest;

public interface  AuthService {
    AuthResponse auth(AuthRequest request);

    User getUserFromToken(ServletRequest servletRequest);
}
