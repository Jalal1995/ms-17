package com.example.ms17task.jwt.impl;

import com.example.ms17task.jwt.JwtService;
import com.example.ms17task.model.security.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    private Key key;
    @Value("${issue.key}")
    private String issueKey;

    @PostConstruct
    public void init() {
        byte[] keyBytes;
        keyBytes = Decoders.BASE64.decode(issueKey);
        key = Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String issueToken(User user) {

        List<String> collect = user
                .getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();


        final JwtBuilder jwtBuilder = Jwts
                .builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(
                        Duration.ofSeconds(300))))


                .addClaims(Map.of("role", collect))

                .setHeader(Map.of("type", "JWT"))

                .signWith(key, SignatureAlgorithm.HS512);
        return jwtBuilder.compact();

    }

    @Override
    public Claims verifyToken(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
