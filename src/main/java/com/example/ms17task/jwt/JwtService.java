package com.example.ms17task.jwt;


import com.example.ms17task.model.security.User;
import io.jsonwebtoken.Claims;


public interface JwtService {

    String issueToken(User user);

    Claims verifyToken(String token);
}
