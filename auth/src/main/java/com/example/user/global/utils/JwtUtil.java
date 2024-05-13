package com.example.user.global.utils;


import com.example.user.global.dto.UserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final Long expiration;
    private final SecretKey secretKey;

    public String generateToken(UserDto req){
        String token = Jwts.builder()
                .claim("id", req.id())
                .claim("email", req.email())
                .claim("nickname", req.nickname())
                .claim("birthDay", req.birthDay())
                .claim("gender", req.gender())
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey)
                .compact();
        return token;
    }
    public UserDto getByEmailFromTokenAndValidate(String token){
        Claims payload = (Claims) Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return new UserDto(
                payload.get("id").toString(),
                payload.get("email").toString(),
                payload.get("nickname").toString(),
                payload.get("birthDay").toString(),
                payload.get("gender").toString());
    }


    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration}") Long expiration
    ) {
        this.expiration = expiration;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }


}
