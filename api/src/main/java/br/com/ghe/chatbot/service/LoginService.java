package br.com.ghe.chatbot.service;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.dto.request.LoginRequest;
import br.com.ghe.chatbot.dto.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtEncoder jwtEncoder;
    private final PasswordEncoder passwordEncoder;
    private final FindUserService findUserService;

    public LoginResponse login(LoginRequest request) {

        User user = findUserService.findByEmail(request.getEmail());

        if (!isValidPassword(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Usuário ou senha incorretos!");
        }

        long expiresIn = 60000L;

        JwtClaimsSet jwt = JwtClaimsSet.builder()
                .issuer("security-api")
                .subject(user.getName())
                .expiresAt(Instant.now().plusSeconds(expiresIn))
                .issuedAt(Instant.now())
                .claim("email", user.getEmail())
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(jwt)).getTokenValue();

        return new LoginResponse(token);
    }

    private boolean isValidPassword(String password, String savedPassowrd) {
        return passwordEncoder.matches(password, savedPassowrd);
    }
}
