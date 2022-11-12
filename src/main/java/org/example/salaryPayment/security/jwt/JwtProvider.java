package org.example.salaryPayment.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtProvider {

    @Value("$(jwt.secret)")
    private String secret;

    public String generateToken(String login) {
        var id = UUID.randomUUID().toString().replace("-", "");
        var now = new Date();
        var exp = Date.from(LocalDateTime.now().plusHours(24)
                .atZone(ZoneId.systemDefault()).toInstant());

        return  Jwts.builder()
                    .setId(id)
                    .setIssuedAt(now)
                    .setNotBefore(now)
                    .setExpiration(exp)
                    .signWith(getSecretKey())
                    .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getSecretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception expEx) {
            expEx.printStackTrace();
        }
        return false;
    }

    public String getLoginFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSecretKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    private SecretKey getSecretKey() {
        byte[] decodedKey = Base64.getDecoder().decode(this.secret);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
}
