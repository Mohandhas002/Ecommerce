package com.ecommerceproject.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secretKey = "mySecretKeydfsdofodjfjsdpjfpsdjfpjsdfpjsdpfjpsdjfpsjdfpjsdpfjpsdfjpsdjfpsjdfpjsdpfjsdpfjpsdjfpsdjfpsjdfpsjdpjsdfpjsdpf";  // Use a stronger key in production

    @SuppressWarnings("deprecation")
	public String generateToken(String username, String role) {
        return Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // 10 hours expiration
            .signWith(SignatureAlgorithm.HS256, secretKey)
            .compact();
    }
    
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    @SuppressWarnings("deprecation")
	public Claims parseClaims(String token) {
        return Jwts.parser()
            .setSigningKey(secretKey)
            .parseClaimsJws(token)
            .getBody();
    }

    public boolean isTokenExpired(String token) {
        return parseClaims(token).getExpiration().before(new Date());
    }

    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }
}
