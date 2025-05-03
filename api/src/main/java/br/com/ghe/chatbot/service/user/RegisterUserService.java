package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.repository.UserRepository;
import br.com.ghe.chatbot.service.user.validators.UniqueEmailValidatorService;
import br.com.ghe.chatbot.service.utilities.NowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.ghe.chatbot.mapper.user.RegisterUserMapper.toEntity;
import static br.com.ghe.chatbot.mapper.user.RegisterUserMapper.toResponse;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;
    private final UniqueEmailValidatorService uniqueEmailValidatorService;
    private final PasswordEncoder passwordEncoder;
    private final NowService nowService;

    @Transactional
    public UserResponse register(RegisterUserRequest request) {

        uniqueEmailValidatorService.validate(request.getEmail());

        UserDomain user = toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(nowService.now());

        userRepository.save(user);

        return toResponse(user);
    }
}
