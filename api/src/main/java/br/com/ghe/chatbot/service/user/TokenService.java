package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TokenService {

    public static final long TOKEN_DEFAULT_EXPIRES_IN = 60000L;
    public static final String ISSUER = "ghe-chatbot-api";
    public static final String ID_CLAIM = "id";

    private final JwtEncoder jwtEncoder;

    public String createToken(User user) {
        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer(ISSUER)
                .subject(user.getName())
                .expiresAt(Instant.now().plusSeconds(TOKEN_DEFAULT_EXPIRES_IN))
                .issuedAt(Instant.now())
                .claim(ID_CLAIM, user.getId())
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();
    }
}
