package org.example.salaryPayment.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.salaryPayment.dto.AuthResponse;
import org.example.salaryPayment.dto.AuthRequest;
import org.example.salaryPayment.persistence.entity.User;
import org.example.salaryPayment.security.jwt.JwtFilter;
import org.example.salaryPayment.security.jwt.JwtProvider;
import org.example.salaryPayment.service.AuthService;
import org.example.salaryPayment.service.UserService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtProvider jwtProvider;
    private final JwtFilter jwtFilter;
    private final UserService userService;

    @Override
    public AuthResponse auth(AuthRequest request) {
        User user = userService.getByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponse(token);
    }

    @Override
    public User getUserFromToken(ServletRequest servletRequest) {
        String token = jwtFilter.getTokenFromRequest((HttpServletRequest) servletRequest);
        User user = null;
        if (token != null && jwtProvider.validateToken(token)) {
            String userLogin = jwtProvider.getLoginFromToken(token);
            user = userService.getByLogin(userLogin);
        }
        return user;
    }
}
