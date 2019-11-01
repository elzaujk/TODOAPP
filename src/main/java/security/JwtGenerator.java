package security;

import config.Constants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import token.Token;


import java.util.Date;

@Component
public class JwtGenerator {
    Date date = new Date();
    Date validy = new Date(date.getTime() * 36000);

    public String generate(Token token) {
        Claims claims = Jwts.claims()
                .setSubject(token.getUsername());
        claims.setSubject(token.getPassword());
        claims.setSubject(token.getRole());
        return Jwts.builder()
                .setClaims(claims).setExpiration(validy)
                .signWith(SignatureAlgorithm.HS512, Constants.getSecret())
                .compact();
    }
}
