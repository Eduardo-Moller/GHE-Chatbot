package br.com.ghe.chatbot.service;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class FindUserService {

    private final UserRepository userRepository;
    private final AuthenticatedUserService authenticatedUserService;

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário não autorizado"));
    }

    public User findAuthenticated(){
        return authenticatedUserService.get();
    }
}
