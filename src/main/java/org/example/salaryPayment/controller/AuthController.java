package org.example.salaryPayment.controller;

import lombok.RequiredArgsConstructor;
import org.example.salaryPayment.dto.AuthRequest;
import org.example.salaryPayment.dto.AuthResponse;
import org.example.salaryPayment.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.auth(request));
    }
}
