package br.com.ghe.chatbot.service.user.search;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.exception.ResourceNotFound;
import br.com.ghe.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchUserService {

    private final UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFound("Usuário não autorizado"));
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmailIgnoreCase(email);
    }
}
