package com.vetturno.vetturno.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    public String generarToken(String email) {

        Date ahora = new Date();
        Date expiracion = new Date(
                ahora.getTime() + expiration
        );

        return Jwts.builder()
                .subject(email)
                .issuedAt(ahora)
                .expiration(expiracion)
                .signWith(getKey())
                .compact();
    }

    public String obtenerEmail(String token) {
        return obtenerClaims(token).getSubject();
    }

    public boolean esTokenValido(String token, String email) {

        String emailToken = obtenerEmail(token);

        return emailToken.equals(email)
                && !estaExpirado(token);
    }

    private boolean estaExpirado(String token) {
        return obtenerClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims obtenerClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getKey() {

        byte[] keyBytes =
                Decoders.BASE64.decode(secret);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}