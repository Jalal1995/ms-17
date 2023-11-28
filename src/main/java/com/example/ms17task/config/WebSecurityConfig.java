package com.example.ms17task.config;

import static org.springframework.security.config.Customizer.withDefaults;

import com.example.ms17task.filter.FilterConfigureAdaptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    public static final String ADMIN = "ADMIN";
    private final FilterConfigureAdaptor configureAdaptor;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.apply(configureAdaptor);

      //  String role_admin = "ROLE_ADMIN";

        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable)


                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers("/company/login").permitAll()
                        .requestMatchers("/company/login/admin").permitAll()
                        .requestMatchers("/company/test/admin").hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
                ).httpBasic(withDefaults());
        return http.build();
    }


    //  @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.builder();

        UserDetails user = users
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = users
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

}
