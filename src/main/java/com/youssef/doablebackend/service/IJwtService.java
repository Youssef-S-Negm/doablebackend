package com.youssef.doablebackend.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IJwtService {

    long getExpiration();

    String generateToken(UserDetails userDetails);

    boolean validateToken(String token, UserDetails userDetails);

    String extractUsername(String token);
}
