package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.mapper.user.RegisterUserMapper;
import br.com.ghe.chatbot.repository.UserRepository;
import br.com.ghe.chatbot.service.user.validators.UniqueEmailValidatorService;
import br.com.ghe.chatbot.service.utilities.NowService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;
    private final UniqueEmailValidatorService uniqueEmailValidatorService;
    private final PasswordEncoder passwordEncoder;
    private final NowService nowService;
    private final RegisterUserMapper registerUserMapper;

    @Transactional
    public UserResponse register(RegisterUserRequest request) {

        uniqueEmailValidatorService.validate(request.getEmail());

        UserDomain user = registerUserMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedAt(nowService.now());

        userRepository.save(user);

        return registerUserMapper.toResponse(user);
    }
}
