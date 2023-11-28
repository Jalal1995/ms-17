package com.example.ms17task.service;

import java.util.Optional;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface AuthService {
    Optional<Authentication> getAuthentication(HttpServletRequest httpServletRequest);
}
