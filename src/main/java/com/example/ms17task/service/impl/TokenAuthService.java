package com.example.ms17task.service.impl;


import com.example.ms17task.jwt.JwtService;
import com.example.ms17task.model.security.User;
import com.example.ms17task.service.AuthService;
import io.jsonwebtoken.Claims;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenAuthService implements AuthService {

  private static final String AUTH_HEADER = "Authorization";
  private static final String BEARER_AUTH_HEADER = "Bearer ";
  private static final String ROLES_CLAIM = "role";

  private final JwtService jwtService;
  private final UserDetailsService userDetailsService;
  @Override
  public Optional<Authentication> getAuthentication(HttpServletRequest httpServletRequest) {
    return Optional.ofNullable(httpServletRequest.getHeader(AUTH_HEADER))
        .filter(this::isBearerAuth)
        .flatMap(this::getAuthenticationBearer);
  }

  private boolean isBearerAuth(String header) {
    return header.toLowerCase().startsWith(BEARER_AUTH_HEADER.toLowerCase());
  }

  private Optional<Authentication> getAuthenticationBearer(String header) {
    String token = header.substring(BEARER_AUTH_HEADER.length()).trim();
    Claims claims = jwtService.verifyToken(token);
    log.trace("The claims parsed {}", claims);
    if (claims.getExpiration().before(new Date())) {
      return Optional.empty();
    }
    return Optional.of(getAuthenticationBearer(claims));
  }

  private Authentication getAuthenticationBearer(Claims claims) {
    List<?> roles = claims.get(ROLES_CLAIM, List.class);
    List<GrantedAuthority> authorityList = null;
    if (roles != null) {
      authorityList = roles
          .stream()
          .map(a -> new SimpleGrantedAuthority(a.toString()))
          .collect(Collectors.toList());
    }
    UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());

    return new UsernamePasswordAuthenticationToken(userDetails, "", authorityList);
  }
}
