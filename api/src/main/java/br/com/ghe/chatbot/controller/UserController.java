package br.com.ghe.chatbot.controller;

import br.com.ghe.chatbot.controller.dto.request.user.LoginRequest;
import br.com.ghe.chatbot.controller.dto.request.user.RegisterUserRequest;
import br.com.ghe.chatbot.controller.dto.response.user.LoginResponse;
import br.com.ghe.chatbot.controller.dto.response.user.UserResponse;
import br.com.ghe.chatbot.service.user.LoginService;
import br.com.ghe.chatbot.service.user.RegisterUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserService registerUserService;
    private final LoginService loginService;

    @PostMapping("/register")
    public UserResponse register(@Valid @RequestBody RegisterUserRequest request) {
        return registerUserService.register(request);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return loginService.login(request);
    }
}

