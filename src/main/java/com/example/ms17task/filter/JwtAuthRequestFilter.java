package com.example.ms17task.filter;



import java.io.IOException;
import java.util.List;
import java.util.Optional;


import com.example.ms17task.service.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Slf4j
@Component
@RequiredArgsConstructor
public class JwtAuthRequestFilter extends OncePerRequestFilter {

    private final List<AuthService> authServices;
    @SneakyThrows
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, jakarta.servlet.FilterChain filterChain) {
        log.info("Filtering request against auth services {}", authServices);
        Optional<Authentication> authOptional = Optional.empty();
        for (AuthService authService : authServices) {
            authOptional = authOptional.or(() -> authService.getAuthentication(request));
        }
        authOptional.ifPresent(auth -> SecurityContextHolder.getContext().setAuthentication(auth));
        filterChain.doFilter(request, response);
    }
}
