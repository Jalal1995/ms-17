package com.example.ms17task.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class FilterConfigureAdaptor extends
    SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

  private final JwtAuthRequestFilter jwtAuthRequestFilter;

  @Override
  public void configure(HttpSecurity http) {
    log.trace("Added auth request filter");
    http.addFilterBefore(jwtAuthRequestFilter, UsernamePasswordAuthenticationFilter.class);  // user token.
  }
}
