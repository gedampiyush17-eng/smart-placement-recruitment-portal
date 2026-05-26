package com.placementportal.backend.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY =
            "myverysecretjwtkeymyverysecretjwtkey123456789";
    public static String generateToken(String email) {

        return Jwts.builder()

                .setSubject(email)

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(System.currentTimeMillis()
                                + 1000 * 60 * 60))

                .signWith(
                        SignatureAlgorithm.HS256,
                        SECRET_KEY)

                .compact();
    }

    public static String extractEmail(String token) {

        Claims claims = Jwts.parser()

                .setSigningKey(SECRET_KEY)

                .parseClaimsJws(token)

                .getBody();

        return claims.getSubject();
    }

    public static boolean validateToken(
            String token,
            String email) {

        String extractedEmail =
                extractEmail(token);

        return extractedEmail.equals(email);
    }
}