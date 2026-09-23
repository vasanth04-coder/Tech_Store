package com.vasanth.Tech_Store.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService
{
    @Value("${jwt.secret}")
     private String secret;

    public String generateToken(Authentication authentication)
    {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.builder()
                .subject(authentication.getName())
                .claim("role","USER")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(key)
                .compact();
    }

    public String extractUser(String token)
    {
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

}

