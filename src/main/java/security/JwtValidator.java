package security;

import config.Constants;
import entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class JwtValidator {
    Logger log = LoggerFactory.getLogger(JwtSuccessHandler.class);

    public User validate(String token) {


        User user = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(Constants.getSecret())
                    .parseClaimsJws(token)
                    .getBody();

            user = new User();
        } catch (Exception e) {
            log.info(e.getMessage());
        }

        return user;
    }
}
