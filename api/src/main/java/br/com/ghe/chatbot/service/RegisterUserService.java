package br.com.ghe.chatbot.service;

import br.com.ghe.chatbot.domain.User;
import br.com.ghe.chatbot.dto.response.UserResponse;
import br.com.ghe.chatbot.dto.request.RegisterUserRequest;
import br.com.ghe.chatbot.mapper.RegisterUserMapper;
import br.com.ghe.chatbot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse register(RegisterUserRequest request) {

        User user = RegisterUserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return RegisterUserMapper.toResponse(user);
    }
}
