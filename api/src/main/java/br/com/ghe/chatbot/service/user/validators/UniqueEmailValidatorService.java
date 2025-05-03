package br.com.ghe.chatbot.service.user.validators;

import br.com.ghe.chatbot.exception.InvalidFieldException;
import br.com.ghe.chatbot.service.user.search.SearchUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniqueEmailValidatorService {

    private final SearchUserService searchUserService;

    public void validate(String email) {
        if (searchUserService.existsByEmail(email)) {
            throw new InvalidFieldException("O seu cadastro não pode ser realizado, valide seu e-mail.");
        }
    }
}
