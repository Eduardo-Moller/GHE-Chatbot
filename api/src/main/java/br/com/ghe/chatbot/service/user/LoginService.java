package br.com.ghe.chatbot.service.user;

import br.com.ghe.chatbot.domain.UserDomain;
import br.com.ghe.chatbot.controller.dto.request.user.LoginRequest;
import br.com.ghe.chatbot.controller.dto.response.user.LoginResponse;
import br.com.ghe.chatbot.service.user.search.SearchUserService;
import br.com.ghe.chatbot.service.user.validators.IsValidPasswordValidatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.ghe.chatbot.mapper.user.LoginMapper.toResponse;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final SearchUserService searchUserService;
    private final TokenService tokenService;
    private final IsValidPasswordValidatorService isValidPasswordValidatorService;

    public LoginResponse login(LoginRequest request) {

        UserDomain user = searchUserService.findByEmail(request.getEmail());

        isValidPasswordValidatorService.validate(request.getPassword(), user);

        String accessToken = tokenService.createToken(user);

        return toResponse(accessToken);
    }
}
