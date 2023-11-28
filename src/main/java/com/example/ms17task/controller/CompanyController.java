package com.example.ms17task.controller;


import com.example.ms17task.dto.CompanyCriteriaDTO;
import com.example.ms17task.dto.CompanyDTO;
import com.example.ms17task.dto.security.Login;
import com.example.ms17task.jwt.JwtService;
import com.example.ms17task.model.security.Authority;
import com.example.ms17task.model.security.User;
import com.example.ms17task.repository.UserRepository;
import com.example.ms17task.service.CompanyService;
import java.util.List;
import java.util.Set;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@Slf4j
public class CompanyController {

    private final CompanyService companyService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final JwtService jwtService;

    @PostMapping("/save")
    public CompanyDTO save(@RequestBody CompanyDTO companyDTO) {
        return companyService.save(companyDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CompanyDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<CompanyDTO>> findAll(@RequestBody CompanyCriteriaDTO criteriaDTO) {
        return ResponseEntity.ok(companyService.findAll(criteriaDTO));
    }


    @GetMapping("/findAll")
    public ResponseEntity<List<CompanyDTO>> findAll2(@AuthenticationPrincipal UserDetails userDetails,
                                                     @RequestHeader(value = "Authorization")  String token) {
        log.info("user name {} " + userDetails.getUsername());
        log.info("Token {} "+ token);


        return ResponseEntity.ok(companyService.findAll());
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }

    @GetMapping("/test/admin")
    public ResponseEntity<String> testAdmin() {
        return ResponseEntity.ok("test admin");
    }

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        User user = new User();
        user.setUsername(login.getUsername());
        user.setPassword(passwordEncoder.encode(login.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        Authority authority2 = new Authority();
        authority2.setAuthority("ROLE_USER");
        authority2.setUser(user);
        user.setAuthorities(Set.of(authority2));
        String s = jwtService.issueToken(user);
        System.out.println(s);
        user.setIssueToken(s);
        userRepository.save(user);
        return ResponseEntity.ok(s);
    }

    @GetMapping("/login/admin")
    public ResponseEntity<String> adminLogin(@RequestBody Login login) {
        User user = new User();
        user.setUsername(login.getUsername());
        user.setPassword(passwordEncoder.encode(login.getPassword()));
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);
        Authority authority2 = new Authority();
        authority2.setAuthority("ROLE_USER");
        authority2.setUser(user);
        Authority authority = new Authority();
        authority.setAuthority("ROLE_ADMIN");
        authority.setUser(user);
        user.setAuthorities(Set.of(authority2, authority));
        String s = jwtService.issueToken(user);
        System.out.println(s);
        user.setIssueToken(s);
        userRepository.save(user);
        return ResponseEntity.ok(s);
    }


}
