package com.example.comment.global.domain.utils;

import com.example.comment.global.domain.entity.UserDto;
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
                .claim("id", req.getId())
                .claim("email", req.getEmail())
                .claim("nickname", req.getNickname())
                .claim("birthDay", req.getBirthDay())
                .claim("gender", req.getGender())
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
            @Value("${token.secret}") String secret,
            @Value("${token.expiration}") Long expiration
    ) {
        this.expiration = expiration;
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes());
    }


}
