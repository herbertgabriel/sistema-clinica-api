package com.api.clinica.services;

import com.api.clinica.models.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        try {
            var algoritmo = Algorithm.HMAC256("123");
            return JWT.create()
                    .withIssuer("auth0")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(dataExpiration())
                    .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw  new RuntimeException("Error gerar token", exception);
        }
    }

    private Instant dataExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
