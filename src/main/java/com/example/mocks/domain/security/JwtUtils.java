package com.example.mocks.domain.security;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.example.mocks.domain.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
    
    private final String secretKey = "BABUN";
    private int accessTokenLifeTime = 60*60*1000;


    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";


    private final JwtParser jwtParser;


    public JwtUtils() {
        this.jwtParser = Jwts.parser().setSigningKey(this.secretKey);
    }

    public String createToken(User user) {
        var claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("name", user.getName());
        claims.put("email", user.getEmail());

        var finalTokenTime = new Date((new Date()).getTime() + this.accessTokenLifeTime);

        return Jwts
            .builder()
            .setClaims(claims)
            .setExpiration(finalTokenTime)
            .signWith(SignatureAlgorithm.HS256, this.secretKey)
            .compact()
        ;
    }

    private Claims parseJwtClaims(String token) {
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public Claims resolveClaims(HttpServletRequest req) {
        try {
            String token = resolveToken(req);
            if (token != null) {
                return parseJwtClaims(token);
            }
            return null;
        } catch (ExpiredJwtException ex) {
            req.setAttribute("expired", ex.getMessage());
            throw ex;
        } catch (Exception ex) {
            req.setAttribute("invalid", ex.getMessage());
            throw ex;
        }
    }
    public String resolveToken(HttpServletRequest request) {

        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }

    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEmail(Claims claims) {
        return claims.getSubject();
    }

    private List<String> getRoles(Claims claims) {
        return (List<String>) claims.get("roles");
    }

}
