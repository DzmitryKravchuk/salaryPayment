package org.example.salaryPayment.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secretString;

    //private final String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";
    private Key getHmacKey() {
        return new SecretKeySpec(Base64.getDecoder().decode(secretString),
                SignatureAlgorithm.HS256.getJcaName());
    }

    public String generateToken(String login) {
        var id = UUID.randomUUID().toString().replace("-", "");
        var now = new Date();
        var exp = Date.from(LocalDateTime.now().plusHours(24)
                .atZone(ZoneId.systemDefault()).toInstant());

        return Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setNotBefore(now)
                .setExpiration(exp)
                .setSubject(login)
                .signWith(getHmacKey())
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(getHmacKey())
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
                .setSigningKey(getHmacKey())
                .build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

}
