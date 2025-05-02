package br.com.ghe.chatbot.service;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Service
@RequiredArgsConstructor
public class AuthenticatedUserService {

    private final UserRepository userRepository;

    public String getEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getCredentials();
        return jwt.getClaim("email");
    }

    public User get() {
        return userRepository.findByEmail(getEmail())
                .orElseThrow(() -> new ResponseStatusException(INTERNAL_SERVER_ERROR, "Usuário não existe ou não está autenticado"));
    }
}
