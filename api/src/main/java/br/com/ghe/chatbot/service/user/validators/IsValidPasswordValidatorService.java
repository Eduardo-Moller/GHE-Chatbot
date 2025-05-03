package br.com.ghe.chatbot.service.user.validators;

import br.com.ghe.chatbot.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IsValidPasswordValidatorService {

    private final PasswordEncoder passwordEncoder;

    public void validate(String password, UserDomain user) {
        if (!isValidPassword(password, user.getPassword())) {
            throw new BadCredentialsException("Usuário ou senha incorretos!");
        }
    }

    private boolean isValidPassword(String password, String savedPassowrd) {
        return passwordEncoder.matches(password, savedPassowrd);
    }
}
