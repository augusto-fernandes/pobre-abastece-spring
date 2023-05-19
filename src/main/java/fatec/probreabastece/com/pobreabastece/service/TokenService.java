package fatec.probreabastece.com.pobreabastece.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import fatec.probreabastece.com.pobreabastece.model.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(User user){
        return JWT.create()
               // .withIssuer("Produtos")
                .withSubject(user.getNome())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("1111"));
    }
}
