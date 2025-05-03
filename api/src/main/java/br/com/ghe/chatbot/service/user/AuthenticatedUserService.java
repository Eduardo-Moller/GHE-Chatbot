package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.exception.ResourceNotFound;
import br.com.ghe.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import static br.com.ghe.chatbot.service.user.TokenService.ID_CLAIM;

@Service
@RequiredArgsConstructor
public class AuthenticatedUserService {

    private final UserRepository userRepository;

    public Long getId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwt = (Jwt) authentication.getCredentials();
        return jwt.getClaim(ID_CLAIM);
    }

    public UserDomain get() {
        return userRepository.findById(getId())
                .orElseThrow(() -> new ResourceNotFound("Usuário não encontrado!"));
    }
}
